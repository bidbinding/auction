package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.adapter.common.driven.TimestreamConfiguration;
import com.bidbinding.auction.engine.application.core.model.item.ForwardAuctionItem;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.timestreamwrite.TimestreamWriteClient;
import software.amazon.awssdk.services.timestreamwrite.model.Record;
import software.amazon.awssdk.services.timestreamwrite.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ItemTimestreamService {

    public static final String ITEM_ID = "item_id";
    public static final String BID_STATUS = "bid_status";
    public static final String ITEM_STATE = "item_state";
    public static final String BUYER = "buyer";
    public static final String BID_AMOUNT = "amount";
    public static final String WINNER = "winner";

    private final TimestreamWriteClient timestreamWriteClient;
    private final TimestreamConfiguration timestreamConfiguration;

    public WriteRecordsResponse asyncRecordImmutableBid(ForwardAuctionItem item) {

        List<Record> records = new ArrayList<>();
        final long time = System.currentTimeMillis();

        List<Dimension> dimensions = new ArrayList<>();
        final Dimension itemId = Dimension.builder().name(ITEM_ID).value(item.getId()).build();
        final Dimension status = Dimension.builder().name(BID_STATUS).value(item.getBid().getBidPlacementStatus().name()).build();
        final Dimension itemState = Dimension.builder().name(ITEM_STATE).value(item.getItemAuctionState().name()).build();
        final Dimension buyer = Dimension.builder().name(BUYER).value(item.getBid().getBuyer()).build();

        dimensions.add(itemId);
        dimensions.add(status);
        dimensions.add(itemState);
        dimensions.add(buyer);

        Record amount = Record.builder()
                .dimensions(dimensions)
                .measureValueType(MeasureValueType.DOUBLE)
                .measureName(BID_AMOUNT)
                .measureValue(item.getBid().getAmount().toString())
                .time(String.valueOf(time)).build();

        records.add(amount);

        return writeToTimestream(item, records);
    }

    public void concludeItem(ForwardAuctionItem item) {
        List<Record> records = new ArrayList<>();
        final long time = System.currentTimeMillis();

        List<Dimension> dimensions = List.of(
                Dimension.builder().name(ITEM_ID).value(item.getId()).build(),
                Dimension.builder().name(ITEM_STATE).value(item.getItemAuctionState().name()).build()
        );

        Record winner = Record.builder()
                .dimensions(dimensions)
                .measureValueType(MeasureValueType.VARCHAR)
                .measureName(WINNER)
                .measureValue(item.getBid().getBuyer())
                .time(String.valueOf(time)).build();

        records.add(winner);

        writeToTimestream(item, records);
    }

    private WriteRecordsResponse writeToTimestream(ForwardAuctionItem item, List<Record> records) {
        WriteRecordsRequest writeRecordsRequest =
                WriteRecordsRequest.builder()
                        .databaseName(timestreamConfiguration.getDatabase() + item.getTenantId())
                        .tableName(timestreamConfiguration.getTable())
                        .records(records)
                        .build();

        try {
            WriteRecordsResponse writeRecordsResponse = timestreamWriteClient.writeRecords(writeRecordsRequest);
            log.info("WriteRecords Status: " + writeRecordsResponse.sdkHttpResponse().statusCode());
            return writeRecordsResponse;
        } catch (RejectedRecordsException e) {
            log.error("RejectedRecords: " + e);
            for (RejectedRecord rejectedRecord : e.rejectedRecords()) {
                log.error("Rejected Index " + rejectedRecord.recordIndex() + ": "
                        + rejectedRecord.reason());
            }
            log.error("Other records were written successfully. ");
        } catch (Exception e) {
            log.error("Error: " + e);
        }
        return null;

    }

}
