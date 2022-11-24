/*    */ package main.quanthicctech.deptrai;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public final class Main
/*    */   extends JavaPlugin implements Listener {
/*    */   public void onEnable() {
/* 14 */     Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[ ]" + ChatColor.RED + " plugin enabled!");
/* 15 */     getConfig().options().copyDefaults();
/* 16 */     saveDefaultConfig();
/* 17 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void OnPlayerLogin(PlayerLoginEvent e) {
/* 22 */     String hostname = e.getHostname();
/* 23 */     String args = getConfig().getString("IP");
/* 24 */     if (hostname.contains(args)) {
/* 25 */       e.disallow((PlayerLoginEvent.Result)null, "Access by this IP has been restricted!");
/* 26 */       Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[IP Blocker] " + ChatColor.RED + "Login blocked! IP used: " + hostname + " from: " + e.getRealAddress());
/*    */     }
/* 28 */     else if (args == hostname) {
/* 29 */       e.disallow((PlayerLoginEvent.Result)null, "Access by this IP has been restricted!");
/* 30 */       Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[IP Blocker] " + ChatColor.RED + "Login blocked! IP used: " + hostname + " from: " + e.getRealAddress());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 35 */     Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "[IP Blocker]" + ChatColor.RED + " plugin disabled!");
/*    */   }
/*    */ }
