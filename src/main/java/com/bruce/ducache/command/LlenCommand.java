package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class LlenCommand implements Command {


    @Override
    public String name() {
        return "LLEN";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        return Reply.integer(cache.llen(key));
    }

}
