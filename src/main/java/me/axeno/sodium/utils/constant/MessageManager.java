package me.axeno.sodium.utils.constant;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class MessageManager
{

    /**
     * Sends a formatted message to the player with an accompanying sound.
     *
     * @param player  The player to send the message to
     * @param message The content of the message
     * @param messageType The type of message (determines the sound played)
     */
    public static void sendMessageType(Player player, String message, MessageType messageType, boolean sound)
    {
        if(sound) {
            assert getSound(messageType) != null;
            player.playSound(player.getLocation(), getSound(messageType), 1, 1);
        }

        String messageStr = "§8(" + getPrefixType(messageType) + "§8) " + Prefix.SODIUM + " §7» " + message;

        player.sendMessage(messageStr);
    }

    /**
     * Sends a formatted message to the player with an accompanying sound.
     *
     * @param player  The player to send the message to
     * @param message The content of the message
     * @param prefix  The prefix for the message
     * @param type    The type of message (determines the sound played)
     */
    public static void sendMessage(Player player, String message, Prefix prefix, MessageType type) {
        player.playSound(player.getLocation(), getSound(type), 1, 1);

        String messageStr = Prefix.SODIUM + " §7» " + message;

        player.sendMessage(messageStr);

    }


    private static String getPrefixType(MessageType type) {
        return switch (type) {
            case ERROR -> "§c❗";
            case WARNING -> "§6⚠";
            case SUCCESS -> "§a✔";
            case INFO -> "§bⓘ";
            default -> "§7";
        };
    }

    private static Sound getSound(MessageType type) {
        return switch (type) {
            case ERROR, WARNING -> Sound.BLOCK_NOTE_BLOCK_BASS;
            case SUCCESS -> Sound.BLOCK_NOTE_BLOCK_BELL;
            case INFO -> Sound.BLOCK_NOTE_BLOCK_BIT;
        };
    }

}
