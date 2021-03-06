import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
@Implements("Texture")
public class Texture extends Node {
   @ObfuscatedName("t")
   static int[] field1865;
   @ObfuscatedName("l")
   @Export("fileIds")
   int[] fileIds;
   @ObfuscatedName("g")
   @Export("pixels")
   int[] pixels;
   @ObfuscatedName("e")
   boolean field1869;
   @ObfuscatedName("k")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("m")
   int field1874;
   @ObfuscatedName("v")
   int field1868;
   @ObfuscatedName("p")
   int[] field1864;
   @ObfuscatedName("u")
   int field1871;
   @ObfuscatedName("s")
   int[] field1867;
   @ObfuscatedName("w")
   int[] field1872;

   Texture(Buffer var1) {
      this.loaded = false;
      this.field1868 = var1.readUnsignedShort();
      this.field1869 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.fileIds = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.fileIds[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1867 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1867[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1872 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1872[var3] = var1.readUnsignedByte();
            }
         }

         this.field1864 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1864[var3] = var1.readInt();
         }

         this.field1874 = var1.readUnsignedByte();
         this.field1871 = var1.readUnsignedByte();
         this.pixels = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @Export("resetPixels")
   void resetPixels() {
      this.pixels = null;
   }

   @ObfuscatedName("a")
   boolean method2487(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.fileIds.length; ++var5) {
         if(var4.method4090(this.fileIds[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.pixels = new int[var5];

      for(int var6 = 0; var6 < this.fileIds.length; ++var6) {
         int var8 = this.fileIds[var6];
         byte[] var10 = var4.method4088(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class36.decodeSprite(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            ModIcon var11 = new ModIcon();
            var11.width = class286.field3793;
            var11.originalHeight = class286.field3792;
            var11.offsetX = class286.field3795[0];
            var11.offsetY = class31.offsetsY[0];
            var11.originalWidth = class286.field3797[0];
            var11.height = class90.field1405[0];
            var11.palette = class286.field3796;
            var11.pixels = class177.spritePixels[0];
            class18.method138();
            var7 = var11;
         }

         var7.method4967();
         var10 = var7.pixels;
         int[] var18 = var7.palette;
         int var12 = this.field1864[var6];
         if((var12 & -16777216) == 16777216) {
            ;
         }

         if((var12 & -16777216) == 33554432) {
            ;
         }

         int var13;
         int var14;
         int var15;
         int var16;
         if((var12 & -16777216) == 50331648) {
            var13 = var12 & 16711935;
            var14 = var12 >> 8 & 255;

            for(var15 = 0; var15 < var18.length; ++var15) {
               var16 = var18[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var18[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var18.length; ++var13) {
            var18[var13] = Graphics3D.adjustRGB(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1867[var6 - 1];
         }

         if(var13 == 0) {
            if(var3 == var7.originalWidth) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.pixels[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var18[var10[(var15 >> 1 << 6) + (var16 >> 1)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.pixels[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var13 == 1) {
            ;
         }

         if(var13 == 2) {
            ;
         }

         if(var13 == 3) {
            ;
         }
      }

      return true;
   }

   @ObfuscatedName("n")
   void method2488(int var1) {
      if(this.pixels != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1874 == 1 || this.field1874 == 3) {
            if(field1865 == null || field1865.length < this.pixels.length) {
               field1865 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = var2 * var1 * this.field1871;
            var5 = var3 - 1;
            if(this.field1874 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1865[var6] = this.pixels[var7];
            }

            var10 = this.pixels;
            this.pixels = field1865;
            field1865 = var10;
         }

         if(this.field1874 == 2 || this.field1874 == 4) {
            if(field1865 == null || field1865.length < this.pixels.length) {
               field1865 = new int[this.pixels.length];
            }

            if(this.pixels.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.pixels.length;
            var4 = this.field1871 * var1;
            var5 = var2 - 1;
            if(this.field1874 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1865[var8] = this.pixels[var9];
               }
            }

            var10 = this.pixels;
            this.pixels = field1865;
            field1865 = var10;
         }

      }
   }
}
