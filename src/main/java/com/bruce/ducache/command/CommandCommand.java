package com.bruce.ducache.command;

import com.bruce.ducache.core.Command;
import com.bruce.ducache.core.Commands;
import com.bruce.ducache.core.DuCache;
import com.bruce.ducache.core.Reply;

/**
 * @date 2024/6/19
 */
public class CommandCommand implements Command {


    @Override
    public String name() {
        return "COMMAND";
    }

    @Override
    public Reply<?> exec(DuCache cache, String[] args) {
        return Reply.array(Commands.getCommandNames());
    }
}
