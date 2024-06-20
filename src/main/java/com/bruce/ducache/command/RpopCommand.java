package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class RpopCommand implements Command {


    @Override
    public String name() {
        return "RPOP";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        int count = 1;
        if(args.length > 6){
            String val = getVal(args);
            count = Integer.parseInt(val);
            return Reply.array(cache.rpop(key, count));
        }
        String[] rpop = cache.rpop(key, count);
        return Reply.bulkString(rpop == null ? null : rpop[0]);
    }

}
