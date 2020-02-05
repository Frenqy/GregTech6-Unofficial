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

package gregtech.blocks.tree;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.block.IBlockToolable;
import gregapi.block.ToolCompat;
import gregapi.block.tree.BlockBaseLog;
import gregapi.data.CS.BlocksGT;
import gregapi.data.IL;
import gregapi.data.LH;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.old.Textures;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockTreeLogBFireProof extends BlockBaseLog implements IBlockToolable {
	public BlockTreeLogBFireProof(String aUnlocalised) {
		super(null, aUnlocalised, Material.wood, soundTypeWood, 4, Textures.BlockIcons.LOGS_B);
		
		LH.add(getUnlocalizedName()+ ".0.name", "Hazel Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".4.name", "Hazel Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".8.name", "Hazel Log (Fireproof)");
		LH.add(getUnlocalizedName()+".12.name", "Hazel Log (Fireproof)");
		OM.reg(ST.make(this, 1, 0), "logWood");
		OM.reg(ST.make(this, 1, 4), "logWood");
		OM.reg(ST.make(this, 1, 8), "logWood");
		OM.reg(ST.make(this, 1,12), "logWood");
		
		LH.add(getUnlocalizedName()+ ".1.name", "Cinnamon Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".5.name", "Cinnamon Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".9.name", "Cinnamon Log (Fireproof)");
		LH.add(getUnlocalizedName()+".13.name", "Cinnamon Log (Fireproof)");
		OM.reg(ST.make(this, 1, 1), "logWood");
		OM.reg(ST.make(this, 1, 5), "logWood");
		OM.reg(ST.make(this, 1, 9), "logWood");
		OM.reg(ST.make(this, 1,13), "logWood");
		
		LH.add(getUnlocalizedName()+ ".2.name", "Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".6.name", "Log (Fireproof)");
		LH.add(getUnlocalizedName()+".10.name", "Log (Fireproof)");
		LH.add(getUnlocalizedName()+".14.name", "Log (Fireproof)");
		OM.reg(ST.make(this, 1, 2), "logWood");
		OM.reg(ST.make(this, 1, 6), "logWood");
		OM.reg(ST.make(this, 1,10), "logWood");
		OM.reg(ST.make(this, 1,14), "logWood");
		
		LH.add(getUnlocalizedName()+ ".3.name", "Rainbowood Log (Fireproof)");
		LH.add(getUnlocalizedName()+ ".7.name", "Rainbowood Log (Fireproof)");
		LH.add(getUnlocalizedName()+".11.name", "Rainbowood Log (Fireproof)");
		LH.add(getUnlocalizedName()+".15.name", "Rainbowood Log (Fireproof)");
		OM.reg(ST.make(this, 1, 3), "logWood");
		OM.reg(ST.make(this, 1, 7), "logWood");
		OM.reg(ST.make(this, 1,11), "logWood");
		OM.reg(ST.make(this, 1,15), "logWood");
	}
	
	@Override public int getLeavesRangeSide(byte aMetaData) {return 0;}
	@Override public int getLeavesRangeYPos(byte aMetaData) {return 0;}
	@Override public int getLeavesRangeYNeg(byte aMetaData) {return 0;}
	
	@Override
	public long onToolClick(String aTool, long aRemainingDurability, long aQuality, Entity aPlayer, List<String> aChatReturn, IInventory aPlayerInventory, boolean aSneaking, ItemStack aStack, World aWorld, byte aSide, int aX, int aY, int aZ, float aHitX, float aHitY, float aHitZ) {
		if (aTool.equals(TOOL_axe) || aTool.equals(TOOL_saw) || aTool.equals(TOOL_knife)) {
			if (aWorld.isRemote) return 0;
			byte aMeta = (byte)aWorld.getBlockMetadata(aX, aY, aZ);
			aWorld.setBlock(aX, aY, aZ, BlocksGT.BeamB, aMeta, 3);
			UT.Inventories.addStackToPlayerInventoryOrDrop(aPlayer instanceof EntityPlayer ? (EntityPlayer)aPlayer : null, (aMeta & 3) == 1 ? ST.make(MD.HaC, "cinnamonItem", 1, 0, IL.Food_Cinnamon) : OM.dust(MT.Bark), aWorld, aX+OFFSETS_X[aSide], aY+OFFSETS_Y[aSide], aZ+OFFSETS_Z[aSide]);
			return aTool.equals(TOOL_axe) ? 500 : 1000;
		}
		return ToolCompat.onToolClick(this, aTool, aRemainingDurability, aQuality, aPlayer, aChatReturn, aPlayerInventory, aSneaking, aStack, aWorld, aSide, aX, aY, aZ, aHitX, aHitY, aHitZ);
	}
}
