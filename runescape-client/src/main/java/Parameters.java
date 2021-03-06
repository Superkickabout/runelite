import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jn")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("a")
   public static final Parameters field3727;
   @ObfuscatedName("j")
   public static final Parameters field3713;
   @ObfuscatedName("n")
   public static final Parameters field3714;
   @ObfuscatedName("s")
   public static final Parameters field3712;
   @ObfuscatedName("u")
   public static final Parameters field3722;
   @ObfuscatedName("e")
   public static final Parameters field3717;
   @ObfuscatedName("r")
   public static final Parameters field3715;
   @ObfuscatedName("l")
   public static final Parameters field3718;
   @ObfuscatedName("g")
   public static final Parameters field3720;
   @ObfuscatedName("v")
   public static final Parameters field3716;
   @ObfuscatedName("m")
   public static final Parameters field3724;
   @ObfuscatedName("w")
   public static final Parameters field3721;
   @ObfuscatedName("k")
   public static final Parameters field3725;
   @ObfuscatedName("t")
   public static final Parameters field3726;
   @ObfuscatedName("p")
   public static final Parameters field3719;
   @ObfuscatedName("c")
   @Export("key")
   public final String key;

   static {
      field3727 = new Parameters("12", "12");
      field3713 = new Parameters("10", "10");
      field3714 = new Parameters("8", "8");
      field3715 = new Parameters("7", "7");
      field3716 = new Parameters("1", "1");
      field3717 = new Parameters("15", "15");
      field3718 = new Parameters("5", "5");
      field3712 = new Parameters("11", "11");
      field3721 = new Parameters("3", "3");
      field3719 = new Parameters("9", "9");
      field3724 = new Parameters("6", "6");
      field3722 = new Parameters("13", "13");
      field3720 = new Parameters("4", "4");
      field3725 = new Parameters("14", "14");
      field3726 = new Parameters("2", "2");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }
}
