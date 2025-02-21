package net.minecraft.client.gui;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GuiOverlayDebug extends Gui {
   private final Minecraft field_175242_a;
   private final FontRenderer field_175241_f;

   public GuiOverlayDebug(Minecraft p_i45543_1_) {
      this.field_175242_a = p_i45543_1_;
      this.field_175241_f = p_i45543_1_.field_71466_p;
   }

   public void func_175237_a(ScaledResolution p_175237_1_) {
      this.field_175242_a.field_71424_I.func_76320_a("debug");
      GlStateManager.func_179094_E();
      this.func_180798_a();
      this.func_175239_b(p_175237_1_);
      GlStateManager.func_179121_F();
      if(this.field_175242_a.field_71474_y.field_74332_R) {
         this.func_181554_e();
      }

      this.field_175242_a.field_71424_I.func_76319_b();
   }

   private boolean func_175236_d() {
      return this.field_175242_a.field_71439_g.func_175140_cp() || this.field_175242_a.field_71474_y.field_178879_v;
   }

   protected void func_180798_a() {
      List<String> list = this.call();

      for(int i = 0; i < list.size(); ++i) {
         String s = (String)list.get(i);
         if(!Strings.isNullOrEmpty(s)) {
            int j = this.field_175241_f.field_78288_b;
            int k = this.field_175241_f.func_78256_a(s);
            int l = 2;
            int i1 = 2 + j * i;
            func_73734_a(1, i1 - 1, 2 + k + 1, i1 + j - 1, -1873784752);
            this.field_175241_f.func_78276_b(s, 2, i1, 14737632);
         }
      }

   }

   protected void func_175239_b(ScaledResolution p_175239_1_) {
      List<String> list = this.func_175238_c();

      for(int i = 0; i < list.size(); ++i) {
         String s = (String)list.get(i);
         if(!Strings.isNullOrEmpty(s)) {
            int j = this.field_175241_f.field_78288_b;
            int k = this.field_175241_f.func_78256_a(s);
            int l = p_175239_1_.func_78326_a() - 2 - k;
            int i1 = 2 + j * i;
            func_73734_a(l - 1, i1 - 1, l + k + 1, i1 + j - 1, -1873784752);
            this.field_175241_f.func_78276_b(s, l, i1, 14737632);
         }
      }

   }

   protected List<String> call() {
      BlockPos blockpos = new BlockPos(this.field_175242_a.func_175606_aa().field_70165_t, this.field_175242_a.func_175606_aa().func_174813_aQ().field_72338_b, this.field_175242_a.func_175606_aa().field_70161_v);
      if(this.func_175236_d()) {
         return Lists.newArrayList(new String[]{"Minecraft 1.8.9 (" + this.field_175242_a.func_175600_c() + "/" + ClientBrandRetriever.getClientModName() + ")", this.field_175242_a.field_71426_K, this.field_175242_a.field_71438_f.func_72735_c(), this.field_175242_a.field_71438_f.func_72723_d(), "P: " + this.field_175242_a.field_71452_i.func_78869_b() + ". T: " + this.field_175242_a.field_71441_e.func_72981_t(), this.field_175242_a.field_71441_e.func_72827_u(), "", String.format("Chunk-relative: %d %d %d", new Object[]{Integer.valueOf(blockpos.func_177958_n() & 15), Integer.valueOf(blockpos.func_177956_o() & 15), Integer.valueOf(blockpos.func_177952_p() & 15)})});
      } else {
         Entity entity = this.field_175242_a.func_175606_aa();
         EnumFacing enumfacing = entity.func_174811_aO();
         String s = "Invalid";
         switch(enumfacing) {
         case NORTH:
            s = "Towards negative Z";
            break;
         case SOUTH:
            s = "Towards positive Z";
            break;
         case WEST:
            s = "Towards negative X";
            break;
         case EAST:
            s = "Towards positive X";
         }

         List<String> list = Lists.newArrayList(new String[]{"Minecraft 1.8.9 (" + this.field_175242_a.func_175600_c() + "/" + ClientBrandRetriever.getClientModName() + ")", this.field_175242_a.field_71426_K, this.field_175242_a.field_71438_f.func_72735_c(), this.field_175242_a.field_71438_f.func_72723_d(), "P: " + this.field_175242_a.field_71452_i.func_78869_b() + ". T: " + this.field_175242_a.field_71441_e.func_72981_t(), this.field_175242_a.field_71441_e.func_72827_u(), "", String.format("XYZ: %.3f / %.5f / %.3f", new Object[]{Double.valueOf(this.field_175242_a.func_175606_aa().field_70165_t), Double.valueOf(this.field_175242_a.func_175606_aa().func_174813_aQ().field_72338_b), Double.valueOf(this.field_175242_a.func_175606_aa().field_70161_v)}), String.format("Block: %d %d %d", new Object[]{Integer.valueOf(blockpos.func_177958_n()), Integer.valueOf(blockpos.func_177956_o()), Integer.valueOf(blockpos.func_177952_p())}), String.format("Chunk: %d %d %d in %d %d %d", new Object[]{Integer.valueOf(blockpos.func_177958_n() & 15), Integer.valueOf(blockpos.func_177956_o() & 15), Integer.valueOf(blockpos.func_177952_p() & 15), Integer.valueOf(blockpos.func_177958_n() >> 4), Integer.valueOf(blockpos.func_177956_o() >> 4), Integer.valueOf(blockpos.func_177952_p() >> 4)}), String.format("Facing: %s (%s) (%.1f / %.1f)", new Object[]{enumfacing, s, Float.valueOf(MathHelper.func_76142_g(entity.field_70177_z)), Float.valueOf(MathHelper.func_76142_g(entity.field_70125_A))})});
         if(this.field_175242_a.field_71441_e != null && this.field_175242_a.field_71441_e.func_175667_e(blockpos)) {
            Chunk chunk = this.field_175242_a.field_71441_e.func_175726_f(blockpos);
            list.add("Biome: " + chunk.func_177411_a(blockpos, this.field_175242_a.field_71441_e.func_72959_q()).field_76791_y);
            list.add("Light: " + chunk.func_177443_a(blockpos, 0) + " (" + chunk.func_177413_a(EnumSkyBlock.SKY, blockpos) + " sky, " + chunk.func_177413_a(EnumSkyBlock.BLOCK, blockpos) + " block)");
            DifficultyInstance difficultyinstance = this.field_175242_a.field_71441_e.func_175649_E(blockpos);
            if(this.field_175242_a.func_71387_A() && this.field_175242_a.func_71401_C() != null) {
               EntityPlayerMP entityplayermp = this.field_175242_a.func_71401_C().func_71203_ab().func_177451_a(this.field_175242_a.field_71439_g.func_110124_au());
               if(entityplayermp != null) {
                  difficultyinstance = entityplayermp.field_70170_p.func_175649_E(new BlockPos(entityplayermp));
               }
            }

            list.add(String.format("Local Difficulty: %.2f (Day %d)", new Object[]{Float.valueOf(difficultyinstance.func_180168_b()), Long.valueOf(this.field_175242_a.field_71441_e.func_72820_D() / 24000L)}));
         }

         if(this.field_175242_a.field_71460_t != null && this.field_175242_a.field_71460_t.func_147702_a()) {
            list.add("Shader: " + this.field_175242_a.field_71460_t.func_147706_e().func_148022_b());
         }

         if(this.field_175242_a.field_71476_x != null && this.field_175242_a.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_175242_a.field_71476_x.func_178782_a() != null) {
            BlockPos blockpos1 = this.field_175242_a.field_71476_x.func_178782_a();
            list.add(String.format("Looking at: %d %d %d", new Object[]{Integer.valueOf(blockpos1.func_177958_n()), Integer.valueOf(blockpos1.func_177956_o()), Integer.valueOf(blockpos1.func_177952_p())}));
         }

         return list;
      }
   }

   protected List<String> func_175238_c() {
      long i = Runtime.getRuntime().maxMemory();
      long j = Runtime.getRuntime().totalMemory();
      long k = Runtime.getRuntime().freeMemory();
      long l = j - k;
      List<String> list = Lists.newArrayList(new String[]{String.format("Java: %s %dbit", new Object[]{System.getProperty("java.version"), Integer.valueOf(this.field_175242_a.func_147111_S()?64:32)}), String.format("Mem: % 2d%% %03d/%03dMB", new Object[]{Long.valueOf(l * 100L / i), Long.valueOf(func_175240_a(l)), Long.valueOf(func_175240_a(i))}), String.format("Allocated: % 2d%% %03dMB", new Object[]{Long.valueOf(j * 100L / i), Long.valueOf(func_175240_a(j))}), "", String.format("CPU: %s", new Object[]{OpenGlHelper.func_183029_j()}), "", String.format("Display: %dx%d (%s)", new Object[]{Integer.valueOf(Display.getWidth()), Integer.valueOf(Display.getHeight()), GL11.glGetString(7936)}), GL11.glGetString(7937), GL11.glGetString(7938)});
      if(this.func_175236_d()) {
         return list;
      } else {
         if(this.field_175242_a.field_71476_x != null && this.field_175242_a.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_175242_a.field_71476_x.func_178782_a() != null) {
            BlockPos blockpos = this.field_175242_a.field_71476_x.func_178782_a();
            IBlockState iblockstate = this.field_175242_a.field_71441_e.func_180495_p(blockpos);
            if(this.field_175242_a.field_71441_e.func_175624_G() != WorldType.field_180272_g) {
               iblockstate = iblockstate.func_177230_c().func_176221_a(iblockstate, this.field_175242_a.field_71441_e, blockpos);
            }

            list.add("");
            list.add(String.valueOf(Block.field_149771_c.func_177774_c(iblockstate.func_177230_c())));

            for(Entry<IProperty, Comparable> entry : iblockstate.func_177228_b().entrySet()) {
               String s = ((Comparable)entry.getValue()).toString();
               if(entry.getValue() == Boolean.TRUE) {
                  s = EnumChatFormatting.GREEN + s;
               } else if(entry.getValue() == Boolean.FALSE) {
                  s = EnumChatFormatting.RED + s;
               }

               list.add(((IProperty)entry.getKey()).func_177701_a() + ": " + s);
            }
         }

         return list;
      }
   }

   private void func_181554_e() {
      GlStateManager.func_179097_i();
      FrameTimer frametimer = this.field_175242_a.func_181539_aj();
      int i = frametimer.func_181749_a();
      int j = frametimer.func_181750_b();
      long[] along = frametimer.func_181746_c();
      ScaledResolution scaledresolution = new ScaledResolution(this.field_175242_a);
      int k = i;
      int l = 0;
      func_73734_a(0, scaledresolution.func_78328_b() - 60, 240, scaledresolution.func_78328_b(), -1873784752);

      while(k != j) {
         int i1 = frametimer.func_181748_a(along[k], 30);
         int j1 = this.func_181552_c(MathHelper.func_76125_a(i1, 0, 60), 0, 30, 60);
         this.func_73728_b(l, scaledresolution.func_78328_b(), scaledresolution.func_78328_b() - i1, j1);
         ++l;
         k = frametimer.func_181751_b(k + 1);
      }

      func_73734_a(1, scaledresolution.func_78328_b() - 30 + 1, 14, scaledresolution.func_78328_b() - 30 + 10, -1873784752);
      this.field_175241_f.func_78276_b("60", 2, scaledresolution.func_78328_b() - 30 + 2, 14737632);
      this.func_73730_a(0, 239, scaledresolution.func_78328_b() - 30, -1);
      func_73734_a(1, scaledresolution.func_78328_b() - 60 + 1, 14, scaledresolution.func_78328_b() - 60 + 10, -1873784752);
      this.field_175241_f.func_78276_b("30", 2, scaledresolution.func_78328_b() - 60 + 2, 14737632);
      this.func_73730_a(0, 239, scaledresolution.func_78328_b() - 60, -1);
      this.func_73730_a(0, 239, scaledresolution.func_78328_b() - 1, -1);
      this.func_73728_b(0, scaledresolution.func_78328_b() - 60, scaledresolution.func_78328_b(), -1);
      this.func_73728_b(239, scaledresolution.func_78328_b() - 60, scaledresolution.func_78328_b(), -1);
      if(this.field_175242_a.field_71474_y.field_74350_i <= 120) {
         this.func_73730_a(0, 239, scaledresolution.func_78328_b() - 60 + this.field_175242_a.field_71474_y.field_74350_i / 2, -16711681);
      }

      GlStateManager.func_179126_j();
   }

   private int func_181552_c(int p_181552_1_, int p_181552_2_, int p_181552_3_, int p_181552_4_) {
      return p_181552_1_ < p_181552_3_?this.func_181553_a(-16711936, -256, (float)p_181552_1_ / (float)p_181552_3_):this.func_181553_a(-256, -65536, (float)(p_181552_1_ - p_181552_3_) / (float)(p_181552_4_ - p_181552_3_));
   }

   private int func_181553_a(int p_181553_1_, int p_181553_2_, float p_181553_3_) {
      int i = p_181553_1_ >> 24 & 255;
      int j = p_181553_1_ >> 16 & 255;
      int k = p_181553_1_ >> 8 & 255;
      int l = p_181553_1_ & 255;
      int i1 = p_181553_2_ >> 24 & 255;
      int j1 = p_181553_2_ >> 16 & 255;
      int k1 = p_181553_2_ >> 8 & 255;
      int l1 = p_181553_2_ & 255;
      int i2 = MathHelper.func_76125_a((int)((float)i + (float)(i1 - i) * p_181553_3_), 0, 255);
      int j2 = MathHelper.func_76125_a((int)((float)j + (float)(j1 - j) * p_181553_3_), 0, 255);
      int k2 = MathHelper.func_76125_a((int)((float)k + (float)(k1 - k) * p_181553_3_), 0, 255);
      int l2 = MathHelper.func_76125_a((int)((float)l + (float)(l1 - l) * p_181553_3_), 0, 255);
      return i2 << 24 | j2 << 16 | k2 << 8 | l2;
   }

   private static long func_175240_a(long p_175240_0_) {
      return p_175240_0_ / 1024L / 1024L;
   }
}
