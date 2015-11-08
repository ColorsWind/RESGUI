package org.totemcraftmc.releaseplugin.lib.CommandLib;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommandExecutor {
	
	protected final AbstractCommandExecutor parent;
	protected String permission;
	protected final String key;
	private List<String> alias = new ArrayList<String>(); 
	private final HashMap<String,AbstractCommandExecutor> subCommands = new HashMap<String, AbstractCommandExecutor>();
	private boolean consoleRun;
	private boolean playerRun;
	protected String prefix = "";
	
	public AbstractCommandExecutor(String key,AbstractCommandExecutor parent,boolean consoleRun,boolean playerRun) {
		this.key = key;
		this.parent = parent;
		
		if(parent!=null){
			prefix = parent.prefix;
		}
		
		this.consoleRun = consoleRun;
		this.playerRun = playerRun;
	}
	
	public AbstractCommandExecutor(String key,AbstractCommandExecutor parent) {
		this(key, parent, true, true);
	}
	
	protected abstract boolean onCall(boolean playerRun,CommandSender sender,Player player,String[] args);
	
	protected boolean call(CommandSender sender,String label,String[] args){
		
		boolean console = !(sender instanceof Player);
		if(!console){
			
			if(permission!=null){
				if(!sender.hasPermission(permission)){
					sender.sendMessage(prefix+ChatColor.RED+"你没有权限这样做");
					return true;
				}
			}
			
		}
		
		if(!consoleRun&&console){
			sender.sendMessage(prefix+ChatColor.RED+"这个指令不能通过控制台执行");
			return true;
		}
		
		if(!playerRun&&!console){
			if(((Player)sender).isOp()){
				sender.sendMessage(prefix+ChatColor.RED+"这个指令只能通过控制台执行");
			}
			return true;
		}
		
		if(args.length>0){
			
			String[] newArgs = new String[args.length-1];
			for(int i = 0 ; i < args.length-1 ; i++){
				newArgs[i] =args[i+1]; 
			}
			
			
			AbstractCommandExecutor exe = subCommands.get(args[0]);
			if(exe!=null){
				return exe.call(sender, label, newArgs);
			}else{
				
				for(AbstractCommandExecutor exec : subCommands.values()){
					if(exec.getAlias() == null){
						continue;
					}
					
					for(String alia : exec.getAlias()){
						if(alia.equalsIgnoreCase(args[0])){
							return exec.call(sender, label, newArgs);
						}
					}
				}
				
			}
			
		}
		
		tempSender = new WeakReference<>(sender);
		boolean re = onCall(!console, sender, console?null:(Player)sender, args);
		tempSender = null;
		return re;
		
	}
	
	public final void registerSubCommand(AbstractCommandExecutor exec){
		subCommands.put(exec.getKey(), exec);
	}
	
	public String getKey(){
		return new String(key);
	}
	
	public List<String> getAlias(){
		return alias;
	}
	
	public void setAlias(List<String> alias){
		this.alias = alias;
	}
	
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	
	public void setPermission(String permission){
		this.permission = permission;
	}
	
	public final AbstractCommandExecutor getRootCommand(){
		AbstractCommandExecutor exec = this;
		
		while(exec.parent != null){
			exec = exec.parent;
		}
		
		return exec;
	}
	
	public void setCanConsoleRun(boolean consoleRun){
		this.consoleRun = consoleRun;
	}
	
	public void setCanPlayerRun(boolean playerRun){
		this.playerRun = playerRun;
	}
	
	WeakReference<CommandSender> tempSender;
	protected void msg(String msg){
		CommandSender sender = null;
		if(tempSender == null || (sender = tempSender.get()) == null){
			return;
		}
		sender.sendMessage(prefix+ChatColor.RESET+msg);
	}
	
}
