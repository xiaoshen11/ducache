package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class LindexCommand implements Command {


    @Override
    public String name() {
        return "LINDEX";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        int index = Integer.parseInt(getVal(args));

        return Reply.bulkString(cache.lindex(key,index));
    }

}
