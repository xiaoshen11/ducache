package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/22
 */
public class HexistsCommand implements Command {


    @Override
    public String name() {
        return "HEXISTS";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String hkey = getVal(args);
        return Reply.integer(cache.hexists(key,hkey));
    }
}
