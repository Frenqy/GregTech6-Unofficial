/**
 * Copyright (c) 2019 Gregorius Techneticies
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.item.multiitem.food;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.data.CS.DrinksGT;
import gregapi.data.FL;
import gregapi.data.MD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FoodStatFluid implements IFoodStat {
	public static final FoodStatFluid INSTANCE = new FoodStatFluid();
	
	@Override
	public int getFoodLevel(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getFoodLevel(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getSaturation(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSaturation(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getHydration(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getHydration(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getTemperature(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return DEF_ENV_TEMP;
		return rStats.getTemperature(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getTemperatureEffect(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getTemperatureEffect(aItem, aStack, aPlayer);
	}
	
	@Override
	public boolean alwaysEdible(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return DRINKS_ALWAYS_DRINKABLE || MD.ENVM.mLoaded;
		return rStats.alwaysEdible(aItem, aStack, aPlayer);
	}
	
	@Override
	public boolean isRotten(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return F;
		return rStats.isRotten(aItem, aStack, aPlayer);
	}
	
	@Override
	public EnumAction getFoodAction(Item aItem, ItemStack aStack) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return EnumAction.drink;
		return rStats.getFoodAction(aItem, aStack);
	}
	
	@Override
	public boolean useAppleCoreFunctionality(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return F;
		return rStats.useAppleCoreFunctionality(aItem, aStack, aPlayer);
	}

	@Override
	public int getSweetness(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSweetness(aItem, aStack, aPlayer);
	}

	@Override
	public int getSourness(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSourness(aItem, aStack, aPlayer);
	}

	@Override
	public int getSaltiness(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSaltiness(aItem, aStack, aPlayer);
	}

	@Override
	public int getBitterness(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getBitterness(aItem, aStack, aPlayer);
	}

	@Override
	public int getSavory(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSavory(aItem, aStack, aPlayer);
	}

	@Override
	public boolean isEdible(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return T;
		return rStats.isEdible(aItem, aStack, aPlayer);
	}

	@Override
	public int getFoodWeight(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getFoodWeight(aItem, aStack, aPlayer);
	}

	@Override
	public int getDehydration(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getDehydration(aItem, aStack, aPlayer);
	}

	@Override
	public int[] getFoodGroupTFC(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) {int[] foodGroups = {5}; return foodGroups;}
		return rStats.getFoodGroupTFC(aItem, aStack, aPlayer);
	}

	@Override
	public void onEaten(Item aItem, ItemStack aStack, EntityPlayer aPlayer, boolean aConsumeItem) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return;
		rStats.onEaten(aItem, aStack, aPlayer, aConsumeItem);
	}
	
	@Override
	public void addAdditionalToolTips(Item aItem, List<String> aList, ItemStack aStack, boolean aF3_H) {
		IFoodStat rStats = null;
		FluidStack tFluid = FL.getFluid(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return;
		rStats.addAdditionalToolTips(aItem, aList, aStack, aF3_H);
	}
}
