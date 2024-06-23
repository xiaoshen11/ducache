package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/22
 */
public class HdelCommand implements Command {


    @Override
    public String name() {
        return "HDEL";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String[] hkeys = getParamsNoKey(args);
        return Reply.integer(cache.hdel(key,hkeys));
    }
}
