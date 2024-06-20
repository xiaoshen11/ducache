package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class MsetCommand implements Command {


    @Override
    public String name() {
        return "MSET";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String[] keys = getKeys(args);
        String[] values = getVals(args);
        cache.mset(keys,values);
        return Reply.string(OK);
    }
}
