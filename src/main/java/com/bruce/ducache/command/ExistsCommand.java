package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class ExistsCommand implements Command {


    @Override
    public String name() {
        return "EXISTS";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String[] keys = getParams(args);
        return Reply.integer(cache.exists(keys));
    }

}
