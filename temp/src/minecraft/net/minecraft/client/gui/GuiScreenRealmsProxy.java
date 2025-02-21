package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonRealmsProxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class GuiScreenRealmsProxy extends GuiScreen {
   private RealmsScreen field_154330_a;

   public GuiScreenRealmsProxy(RealmsScreen p_i1087_1_) {
      this.field_154330_a = p_i1087_1_;
      super.field_146292_n = Collections.<GuiButton>synchronizedList(Lists.<GuiButton>newArrayList());
   }

   public RealmsScreen func_154321_a() {
      return this.field_154330_a;
   }

   public void func_73866_w_() {
      this.field_154330_a.init();
      super.func_73866_w_();
   }

   public void func_154325_a(String p_154325_1_, int p_154325_2_, int p_154325_3_, int p_154325_4_) {
      super.func_73732_a(this.field_146289_q, p_154325_1_, p_154325_2_, p_154325_3_, p_154325_4_);
   }

   public void a(String p_a_1_, int p_a_2_, int p_a_3_, int p_a_4_, boolean p_a_5_) {
      if(p_a_5_) {
         super.func_73731_b(this.field_146289_q, p_a_1_, p_a_2_, p_a_3_, p_a_4_);
      } else {
         this.field_146289_q.func_78276_b(p_a_1_, p_a_2_, p_a_3_, p_a_4_);
      }

   }

   public void func_73729_b(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
      this.field_154330_a.blit(p_73729_1_, p_73729_2_, p_73729_3_, p_73729_4_, p_73729_5_, p_73729_6_);
      super.func_73729_b(p_73729_1_, p_73729_2_, p_73729_3_, p_73729_4_, p_73729_5_, p_73729_6_);
   }

   public void func_73733_a(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_) {
      super.func_73733_a(p_73733_1_, p_73733_2_, p_73733_3_, p_73733_4_, p_73733_5_, p_73733_6_);
   }

   public void func_146276_q_() {
      super.func_146276_q_();
   }

   public boolean func_73868_f() {
      return super.func_73868_f();
   }

   public void func_146270_b(int p_146270_1_) {
      super.func_146270_b(p_146270_1_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_154330_a.render(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_146285_a(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_) {
      super.func_146285_a(p_146285_1_, p_146285_2_, p_146285_3_);
   }

   public void func_146279_a(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
      super.func_146279_a(p_146279_1_, p_146279_2_, p_146279_3_);
   }

   public void func_146283_a(List<String> p_146283_1_, int p_146283_2_, int p_146283_3_) {
      super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
   }

   public void func_73876_c() {
      this.field_154330_a.tick();
      super.func_73876_c();
   }

   public int func_154329_h() {
      return this.field_146289_q.field_78288_b;
   }

   public int func_154326_c(String p_154326_1_) {
      return this.field_146289_q.func_78256_a(p_154326_1_);
   }

   public void func_154322_b(String p_154322_1_, int p_154322_2_, int p_154322_3_, int p_154322_4_) {
      this.field_146289_q.func_175063_a(p_154322_1_, (float)p_154322_2_, (float)p_154322_3_, p_154322_4_);
   }

   public List<String> func_154323_a(String p_154323_1_, int p_154323_2_) {
      return this.field_146289_q.func_78271_c(p_154323_1_, p_154323_2_);
   }

   public final void func_146284_a(GuiButton p_146284_1_) throws IOException {
      this.field_154330_a.buttonClicked(((GuiButtonRealmsProxy)p_146284_1_).func_154317_g());
   }

   public void func_154324_i() {
      super.field_146292_n.clear();
   }

   public void func_154327_a(RealmsButton p_154327_1_) {
      super.field_146292_n.add(p_154327_1_.getProxy());
   }

   public List<RealmsButton> func_154320_j() {
      List<RealmsButton> list = Lists.<RealmsButton>newArrayListWithExpectedSize(super.field_146292_n.size());

      for(GuiButton guibutton : super.field_146292_n) {
         list.add(((GuiButtonRealmsProxy)guibutton).func_154317_g());
      }

      return list;
   }

   public void func_154328_b(RealmsButton p_154328_1_) {
      super.field_146292_n.remove(p_154328_1_.getProxy());
   }

   public void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) throws IOException {
      this.field_154330_a.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_146274_d() throws IOException {
      this.field_154330_a.mouseEvent();
      super.func_146274_d();
   }

   public void func_146282_l() throws IOException {
      this.field_154330_a.keyboardEvent();
      super.func_146282_l();
   }

   public void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
      this.field_154330_a.mouseReleased(p_146286_1_, p_146286_2_, p_146286_3_);
   }

   public void func_146273_a(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
      this.field_154330_a.mouseDragged(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
   }

   public void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      this.field_154330_a.keyPressed(p_73869_1_, p_73869_2_);
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      this.field_154330_a.confirmResult(p_73878_1_, p_73878_2_);
   }

   public void func_146281_b() {
      this.field_154330_a.removed();
      super.func_146281_b();
   }
}
