package de.can.pravenlohnsystem.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LohnCommand implements Listener, CommandExecutor {

	public String SYS_MSG = "§7[§aPravenLohnSystem§7] ";
	
	public static FileConfiguration config;
	public static File configfile = new File("PravenLohnSystem/config.yml");

    public LohnCommand(FileConfiguration cooldownconfig) {
        this.config = cooldownconfig;
    }
	
	
	// Map to store the cooldown time for each player
	Map<Player, Long> cooldownTimes = new HashMap<>();
	

	// The cooldown time in seconds
	int COOLDOWN_TIME = 86400; // 24 hours

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lohn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(SYS_MSG + "§cNur ein Spieler kann diesen Befehl ausführen.");
                return true;
            }


            Player player = (Player) sender;
            int timeLeft = CoolDown.getTimeLeft(player, "lohn");
            if (timeLeft > 0) {
                long hours = timeLeft / (60 * 60);
                long minutes = (timeLeft % (60 * 60)) / 60;
                long seconds = (timeLeft % (60 * 60)) % 60;

                StringBuilder message = new StringBuilder();
                message.append(SYS_MSG + "§cDu musst noch ");
                if (hours > 0) {
                    message.append("§c" + hours + " §cStunden, ");
                } else {
                	message.append("warten,");
                }
                if (minutes > 0) {
                    message.append("§c" + minutes + "§c Minuten, ");
                } else {
                	message.append("warten,");
                }
                if (seconds > 0) {
                    message.append("§cund " + seconds + "§c Sekunden warten, ");
                } 
                message.append("§cbevor du deinen Lohn erneut abholen kannst.");

                player.sendMessage(message.toString());
                return true;
            }

            // The player is not on cooldown, execute the command
            // TODO: Add code to give the player their salary here

	        
	        ConfigurationSection loehneSection = config.getConfigurationSection("Loehne");
	        ConfigurationSection steuernSection = config.getConfigurationSection("Steuern");
	        ConfigurationSection koenigsection = config.getConfigurationSection("Könige");
	        int HarenaebuergerLohn = loehneSection.getInt("Harenae.Buerger");
	        int HarenaeredaktionschefLohn = loehneSection.getInt("Harenae.Redaktionschef");
	        int HarenaeRessourcensammlerLohn = loehneSection.getInt("Harenae.Ressourcensammler");
	        int HarenaeLandwirtLohn = loehneSection.getInt("Harenae.Landwirt");
	        int HarenaeMarktführerLohn = loehneSection.getInt("Harenae.Marktführer");
	        int HarenaeWächterLohn = loehneSection.getInt("Harenae.Wächter");
	        int HarenaeRichterLohn = loehneSection.getInt("Harenae.Richter");
	        int HarenaeWachtmeisterLohn = loehneSection.getInt("Harenae.Wachtmeister");
	        int HarenaeArchitektLohn = loehneSection.getInt("Harenae.Architekt");
	        int HarenaeWirtLohn = loehneSection.getInt("Harenae.Wirt");
	        int HarenaeKoenigLohn = loehneSection.getInt("Harenae.Koenig");
	        int HarenaeFinanzministerLohn = loehneSection.getInt("Harenae.Finanzminister");
	        int AkanonbuergerLohn = loehneSection.getInt("Akanon.Buerger");
	        int AkanonredaktionschefLohn = loehneSection.getInt("Akanon.Redaktionschef");
	        int AkanonRessourcensammlerLohn = loehneSection.getInt("Akanon.Ressourcensammler");
	        int AkanonLandwirtLohn = loehneSection.getInt("Akanon.Landwirt");
	        int AkanonMarktführerLohn = loehneSection.getInt("Akanon.Marktführer");
	        int AkanonWächterLohn = loehneSection.getInt("Akanon.Wächter");
	        int AkanonRichterLohn = loehneSection.getInt("Akanon.Richter");
	        int AkanonWachtmeisterLohn = loehneSection.getInt("Akanon.Wachtmeister");
	        int AkanonArchitektLohn = loehneSection.getInt("Akanon.Architekt");
	        int AkanonWirtLohn = loehneSection.getInt("Akanon.Wirt");
	        int AkanonKoenigLohn = loehneSection.getInt("Akanon.Koenig");
	        int AkanonFinanzministerLohn = loehneSection.getInt("Akanon.Finanzminister");
	        int GlaciesbuergerLohn = loehneSection.getInt("Glacies.Buerger");
	        int GlaciesredaktionschefLohn = loehneSection.getInt("Glacies.Redaktionschef");
	        int GlaciesRessourcensammlerLohn = loehneSection.getInt("Glacies.Ressourcensammler");
	        int GlaciesLandwirtLohn = loehneSection.getInt("Glacies.Landwirt");
	        int GlaciesMarktführerLohn = loehneSection.getInt("Glacies.Marktführer");
	        int GlaciesWächterLohn = loehneSection.getInt("Glacies.Wächter");
	        int GlaciesRichterLohn = loehneSection.getInt("Glacies.Richter");
	        int GlaciesWachtmeisterLohn = loehneSection.getInt("Glacies.Wachtmeister");
	        int GlaciesArchitektLohn = loehneSection.getInt("Glacies.Architekt");
	        int GlaciesWirtLohn = loehneSection.getInt("Glacies.Wirt");
	        int GlaciesKoenigLohn = loehneSection.getInt("Glacies.Koenig");
	        int GlaciesFinanzministerLohn = loehneSection.getInt("Glacies.Finanzminister");
	        double harenaeSteuersatz = steuernSection.getDouble("Steuersatzharenae");
	        double akanonSteuersatz = steuernSection.getDouble("Steuersatzakanon");
	        double glaciesSteuersatz = steuernSection.getDouble("Steuersatzglacies");
	        String HarenaeKoenig = koenigsection.getString("Könige.Harenae");
	        String AkanonKoenig = koenigsection.getString("Könige.Akanon");
	        String GlaciesKoenig = koenigsection.getString("Könige.Glacies");



	        
	        // The player is not on cooldown, execute the command
	        if(player.hasPermission("pravenlohnsystem.buerger")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaebuergerLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaebuergerLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaebuergerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaebuergerLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonbuergerLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonbuergerLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonbuergerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonbuergerLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesbuergerLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesbuergerLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesbuergerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesbuergerLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.koenig")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeKoenigLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeKoenigLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeKoenigLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeKoenigLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonKoenigLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonKoenigLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonKoenigLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonKoenigLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesKoenigLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesKoenigLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesKoenigLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesKoenigLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.wirt")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeWirtLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeWirtLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeWirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeWirtLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonWirtLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonWirtLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonWirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonWirtLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + GlaciesWirtLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesWirtLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesWirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesWirtLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.architekt")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeArchitektLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeArchitektLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeArchitektLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeArchitektLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonArchitektLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonArchitektLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonArchitektLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonArchitektLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesArchitektLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesArchitektLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesArchitektLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesArchitektLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.wachtmeister")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeWachtmeisterLohn);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + HarenaeKoenig + " " +  HarenaeWachtmeisterLohn);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeWachtmeisterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonWachtmeisterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + AkanonKoenig + " " +  AkanonWachtmeisterLohn);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonWachtmeisterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesWachtmeisterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + GlaciesKoenig + " " +  GlaciesWachtmeisterLohn);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesWachtmeisterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.richter")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeRichterLohn);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + HarenaeKoenig + " " +  HarenaeRichterLohn);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeRichterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonRichterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + AkanonKoenig + " " +  AkanonRichterLohn);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonRichterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesRichterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + GlaciesKoenig + " " +  GlaciesRichterLohn);
	        		player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesRichterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.wache")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeWächterLohn);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + HarenaeKoenig + " " +  HarenaeWächterLohn);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeWächterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonWächterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + AkanonKoenig + " " +  AkanonWächterLohn);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonWächterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + GlaciesWächterLohn);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank remove " + GlaciesKoenig + " " + GlaciesWächterLohn);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesWächterLohn + "$ erhalten! Da du für den Staat arbeitest, zahlst du keine Steuern! ");
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.finanzminister")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeFinanzministerLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeFinanzministerLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeFinanzministerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeFinanzministerLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonFinanzministerLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonFinanzministerLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonFinanzministerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonFinanzministerLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesFinanzministerLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesFinanzministerLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesFinanzministerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesFinanzministerLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.marktführer")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + HarenaeMarktführerLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeMarktführerLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeMarktführerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeMarktführerLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonMarktführerLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonMarktführerLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonMarktführerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonMarktführerLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesMarktführerLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesMarktführerLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesMarktführerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesMarktführerLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.landwirt")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeLandwirtLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeLandwirtLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeLandwirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeLandwirtLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonLandwirtLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonLandwirtLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonLandwirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonLandwirtLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesLandwirtLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesLandwirtLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesLandwirtLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesLandwirtLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.ressourcensammler")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  HarenaeRessourcensammlerLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeRessourcensammlerLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeRessourcensammlerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeRessourcensammlerLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  AkanonRessourcensammlerLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonRessourcensammlerLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonRessourcensammlerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonRessourcensammlerLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesRessourcensammlerLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesRessourcensammlerLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesRessourcensammlerLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesRessourcensammlerLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	        if(player.hasPermission("pravenlohnsystem.redaktionschef")) {
	        	if(player.hasPermission("pravenlohnsystem.harenaesteuer")) {
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + HarenaeredaktionschefLohn * harenaeSteuersatz);
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + HarenaeKoenig + " " +  HarenaeredaktionschefLohn * harenaeSteuersatz);
	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + HarenaeredaktionschefLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + HarenaeredaktionschefLohn * harenaeSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.akanonsteuer")) {
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + AkanonredaktionschefLohn * akanonSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + AkanonKoenig + " " +  AkanonredaktionschefLohn * akanonSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + AkanonredaktionschefLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + AkanonredaktionschefLohn * akanonSteuersatz + "$." );
	        	} else if(player.hasPermission("pravenlohnsystem.glaciessteuer")) {
	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " +  GlaciesredaktionschefLohn * glaciesSteuersatz);
	    	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rec sharedbank add " + GlaciesKoenig + " " +  GlaciesredaktionschefLohn * glaciesSteuersatz);
	    	        player.sendMessage(SYS_MSG + "§aDu hast deinen Lohn von " + GlaciesredaktionschefLohn + "$ erhalten! Dein Nettolohn beträgt bei dem Aktuellen Steuersatz " + GlaciesredaktionschefLohn * glaciesSteuersatz + "$." );
	        	}
	        } 
	       
	        
	       
	        
	        CoolDown.addCoolDown(player, "lohn", this.COOLDOWN_TIME);
	        final File file = new File("PravenLohnSystem/cooldowns.yml");
	        CoolDown.saveToFile(file);
	        
        
	       return true;
        }
        
	
            // Add a cooldown for the player

           


	    return false;
	
}
}


