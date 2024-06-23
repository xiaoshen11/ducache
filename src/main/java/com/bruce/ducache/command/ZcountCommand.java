package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/23
 */
public class ZcountCommand implements Command {


    @Override
    public String name() {
        return this.getClass().getSimpleName()
                .replace("Command","").toUpperCase();
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String[] params = getParamsNoKey(args);
        double min = Double.parseDouble(params[0]);
        double max = Double.parseDouble(params[1]);
        return Reply.integer(cache.zcount(key,min,max));
    }

}
