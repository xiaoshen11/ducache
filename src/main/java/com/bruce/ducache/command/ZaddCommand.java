package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

import java.util.Arrays;

import static org.springframework.expression.common.ExpressionUtils.toDouble;

/**
 * @date 2024/6/23
 */
public class ZaddCommand implements Command {


    @Override
    public String name() {
        return this.getClass().getSimpleName()
                .replace("Command","").toUpperCase();
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        String key = getKey(args);
        String[] scores = getHkeys(args);
        String[] vals = getHvals(args);
        return Reply.integer(cache.zadd(key, toDouble(scores), vals));
    }

    private double[] toDouble(String[] scores) {
        return Arrays.stream(scores).mapToDouble(Double::parseDouble).toArray();
    }

}
