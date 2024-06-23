package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/23
 */
public class ZcardCommand implements Command {


    @Override
    public String name() {
        return this.getClass().getSimpleName()
                .replace("Command","").toUpperCase();
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        return Reply.integer(cache.zcard(key));
    }

}
