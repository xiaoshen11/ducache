package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class InfoCommand implements Command {

    private static final String INFO = "DuCache server[v1.0.1], created by bruce." + CRLF
            + "Mock Redis Server at 2024-06-19 in Shenzhen." + CRLF;

    @Override
    public String name() {
        return "INFO";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        return Reply.bulkString(INFO);
    }
}
