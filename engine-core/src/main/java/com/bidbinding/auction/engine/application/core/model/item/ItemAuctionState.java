package com.bidbinding.auction.engine.application.core.model.item;

public enum ItemAuctionState {
/*
TODO mfguven : We should draw a simple automata of states

┌─────────────┐         ┌─────────┐         ┌───────────────────┐
│ NOT_STARTED ├─────────► STARTED ├─────────► PENDING_CONCLUDED │
└───────┬─────┘         └─┬──────┬┘         └──┬────────────────┘
        │                 │      │             │
        │                 │      │             │
        │       ┌─────────▼┐    ┌▼──────────┐  │
        └───────► CANCELED │    │ CONCLUDED ◄──┘
                └──────────┘    └───────────┘
 */

    NOT_STARTED,
    STARTED,
    PENDING_CONCLUSION,
    CONCLUDED,
    CANCELLED

}
