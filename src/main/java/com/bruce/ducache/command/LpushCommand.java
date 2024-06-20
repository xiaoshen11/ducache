package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class LpushCommand implements Command {


    @Override
    public String name() {
        return "LPUSH";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String[] values = getParamsNoKey(args);
        return Reply.integer(cache.lpush(key,values));
    }

}
