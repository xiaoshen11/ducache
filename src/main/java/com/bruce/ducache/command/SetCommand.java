package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.Commands;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class SetCommand implements Command {


    @Override
    public String name() {
        return "SET";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String value = getVal(args);
        cache.set(key,value);
        return Reply.string(OK);
    }
}
