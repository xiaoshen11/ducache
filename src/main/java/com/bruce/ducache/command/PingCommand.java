package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class PingCommand implements Command {

    @Override
    public String name() {
        return "PING";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String ret = "PONG";
        if(args.length >= 5) {
            ret = args[4];
        }
        return Reply.string(ret);
    }
}
