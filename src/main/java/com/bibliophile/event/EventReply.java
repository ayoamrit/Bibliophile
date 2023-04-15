package com.bibliophile.event;

import org.jetbrains.annotations.NotNull;

public interface EventReply {
    String eventReply(@NotNull String user,@NotNull String prompt);
}
