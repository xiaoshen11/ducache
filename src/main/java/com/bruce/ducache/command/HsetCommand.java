package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/22
 */
public class HsetCommand implements Command {


    @Override
    public String name() {
        return "HSET";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String[] hkeys = getHkeys(args);
        String[] hvals = getHvals(args);
        return Reply.integer(cache.hset(key,hkeys,hvals));
    }
}
