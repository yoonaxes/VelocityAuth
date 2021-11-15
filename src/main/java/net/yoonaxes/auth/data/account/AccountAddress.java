package net.yoonaxes.auth.data.account;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountAddress {

    @NonNull
    @Getter
    private String firstAddress;

    @NonNull
    @Getter
    private String lastAddress;

    @Getter // TODO: Last address list.
    private List<String> listAddress = Lists.newArrayList(firstAddress, lastAddress);

}
