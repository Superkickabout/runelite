import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
@Implements("WidgetConfig")
public class WidgetConfig extends Node {
   @ObfuscatedName("a")
   @Export("config")
   public int config;

   public WidgetConfig(int var1) {
      this.config = var1;
   }
}
