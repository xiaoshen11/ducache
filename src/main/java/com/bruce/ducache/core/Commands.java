package com.bruce.ducache.core;

import com.bruce.ducache.command.CommandCommand;
import com.bruce.ducache.command.DecrCommand;
import com.bruce.ducache.command.DelCommand;
import com.bruce.ducache.command.ExistsCommand;
import com.bruce.ducache.command.GetCommand;
import com.bruce.ducache.command.IncrCommand;
import com.bruce.ducache.command.InfoCommand;
import com.bruce.ducache.command.LindexCommand;
import com.bruce.ducache.command.LlenCommand;
import com.bruce.ducache.command.LpopCommand;
import com.bruce.ducache.command.LpushCommand;
import com.bruce.ducache.command.LrangeCommand;
import com.bruce.ducache.command.MgetCommand;
import com.bruce.ducache.command.MsetCommand;
import com.bruce.ducache.command.PingCommand;
import com.bruce.ducache.command.RpopCommand;
import com.bruce.ducache.command.RpushCommand;
import com.bruce.ducache.command.SaddCommand;
import com.bruce.ducache.command.ScardCommand;
import com.bruce.ducache.command.SetCommand;
import com.bruce.ducache.command.SismemberCommand;
import com.bruce.ducache.command.SmembersCommand;
import com.bruce.ducache.command.SpopCommand;
import com.bruce.ducache.command.SremCommand;
import com.bruce.ducache.command.StrlenCommand;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2024/6/19
 */
public class Commands {

    private static Map<String, Command> ALL = new LinkedHashMap<>();

    static {
        initCommand();
    }

    private static void initCommand() {
        // common commands
        register(new PingCommand());
        register(new InfoCommand());
        register(new CommandCommand());

        //string
        register(new SetCommand());
        register(new GetCommand());
        register(new StrlenCommand());
        register(new DelCommand());
        register(new ExistsCommand());
        register(new IncrCommand());
        register(new DecrCommand());
        register(new MsetCommand());
        register(new MgetCommand());

        // list
        register(new LpushCommand());
        register(new LpopCommand());
        register(new RpushCommand());
        register(new RpopCommand());
        register(new LlenCommand());
        register(new LindexCommand());
        register(new LrangeCommand());

        // set
        register(new SaddCommand());
        register(new SmembersCommand());
        register(new SismemberCommand());
        register(new ScardCommand());
        register(new SremCommand());
        register(new SpopCommand());



        // hash



        // zset

    }

    public static void register(Command command){
        ALL.put(command.name(), command);
    }

    public static Command get(String name){
        return ALL.get(name);
    }

    public static String[] getCommandNames() {
        return ALL.keySet().toArray(new String[0]);
    }
}
