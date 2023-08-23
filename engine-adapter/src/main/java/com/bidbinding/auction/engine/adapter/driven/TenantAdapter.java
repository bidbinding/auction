package com.bidbinding.auction.engine.adapter.driven;

import com.bidbinding.auction.engine.adapter.common.Adaptor;
import com.bidbinding.auction.engine.application.port.driven.TenancyPort;

@Adaptor
public class TenantAdapter implements TenancyPort {
    @Override
    public String getTenant() {
        return "Tenant1";
    }
}
