package com.aryan.lbrybrowser.listener;

import com.aryan.lbrybrowser.model.WalletBalance;

public interface WalletBalanceListener {
    void onWalletBalanceUpdated(WalletBalance walletBalance);
}
