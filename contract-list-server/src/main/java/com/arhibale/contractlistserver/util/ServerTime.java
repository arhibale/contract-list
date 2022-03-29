package com.arhibale.contractlistserver.util;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServerTime {
    public static LocalDateTime getServerTime() {
        return LocalDateTime.now(Clock.tickSeconds(ZoneId.systemDefault()));
    }
}
