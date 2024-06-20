package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class IncrCommand implements Command {


    @Override
    public String name() {
        return "INCR";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        try {
            return Reply.integer(cache.incr(key));
        }catch (NumberFormatException nfe){
            return Reply.error("NFE " + key + " value[" + cache.get(key) + "] is not integer.");
        }
    }
}
