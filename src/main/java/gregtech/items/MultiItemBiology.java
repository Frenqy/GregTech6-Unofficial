/**
 * Copyright (c) 2020 GregTech-6U Team
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

package gregtech.items;

import gregapi.data.*;
import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandom;
import gregapi.oredict.OreDictItemData;
import gregapi.util.*;
import net.minecraft.init.Items;
import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.util.CR;
import gregapi.util.ST;
import net.minecraft.init.Blocks;

public class MultiItemBiology extends MultiItemRandom{

    public MultiItemBiology() {
        super(MD.GT.mID, "gt.multiitem.biology");
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "GregTech: Biology", this, (short)1000));
    }

    @Override
    public void addItems() {
        IL.Culture_Dish_Empty.set(addItem(1000, "Culture Dish (Empty)", "A fundamental tool of laboratory biology"), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_MSC.set(addItem(1001,"Culture Dish (MSC)","Stem cell culture medium inside"), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_Stem_Cell_Embryonic.set(addItem(1002,"Culture Dish (Inoculated stem cells)","can be cultured in Incubator"), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_Stem_Cell_Somatic.set(addItem(1003,"Culture Dish (stem cells)","Stem cells inside"), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.dust_Inorganic_Salt_Mixture.set(addItem(1004,"Inorganic Salt Mixture Dust","Inorganic salts for cell culture"));
        IL.dust_Tiny_Inorganic_Salt_Mixture.set(addItem(1005,"Tiny InorganicSalt Mixture Dust","Inorganic salts for cell culture"));
        IL.dust_Glucose.set(addItem(1006,"Glucose Dust","Can't be eaten now"));
        IL.Stem_Cell.set(addItem(1007,"Stem Cell","It can differentiate into various cells(But now there are only neuron cells)"));
        IL.Neuron_Cell.set(addItem(1008,"Culture Dish (Neuron Cell)","It's clever"));
        IL.Unformed_Embryo.set(addItem(1009,"Unformed Embryo","It's alive,and it will die for science."));
        IL.Precision_Manipulator.set(addItem(1010,"Percision Manipulator","Very accurate"));
        IL.Lauryl_Sulfate.set(addItem(1011,"Lauryl Sulfate",""));
        IL.SDS.set(addItem(1012,"SDS",""));
        IL.Culture_Dish_Biomass_Flora.set(addItem(1013,"Culture Dish (Biomass Flora)",""), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Mixing_Rod.set(addItem(1014,"Mixing Rod","Used to differentiate bacteria"), new OreDictItemData(MT.GT6U.PTFE, U10*5));
        IL.Culture_Dish_Yeast.set(addItem(1015,"Culture Dish (Yeast)",""), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_Methanogens.set(addItem(1016,"Culture Dish (Methanogens)",""), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_Bacillus.set(addItem(1017,"Culture Dish (Bacillus)",""), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Culture_Dish_Clostridia.set(addItem(1018,"Culture Dish (Clostridia)",""), new OreDictItemData(MT.GT6U.PTFE, U));
        IL.Gene_Samples.set(addItem(1019, "Gene Samples", ""));
        IL.Protein_Sample.set(addItem(1020, "Protein Sample", ""));


        // Bacteria
        RM.Sharpening.addRecipe1(T, 16, 128, OP.stick.mat(MT.GT6U.PTFE, 1), ZL_FS, ZL_FS, IL.Mixing_Rod.get(1));

        RM.Mixer.addRecipe1(T, 16, 128, NI, FL.array(FL.BiomassIC2.make(100), MT.DistWater.fluid(U, T)), FL.array(FL.DilutedBiomass.make(1100)), ZL_IS);
        RM.Mixer.addRecipe1(T, 16, 128, NI, FL.array(FL.Biomass.make(100), MT.DistWater.fluid(U, T)), FL.array(FL.DilutedBiomass.make(1100)), ZL_IS);

        RM.Centrifuge.addRecipe1(T, 16, 128, IL.Food_Candleberry.get(1), FL.array(FL.BioEthanol.make(500)), FL.array(FL.Agar.make(100)), ZL_IS);

        RM.Mixer.addRecipe1(T, 16, 128, IL.dust_Glucose.get(4), FL.array(FL.Agar.make(600), FL.SPSS.make(400)), FL.array(FL.BacteriaMedium.make(1000)), ZL_IS);

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.DilutedBiomass.make(1000)), ZL_FS, IL.Culture_Dish_Biomass_Flora.get(1));

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.BiomassFlora.make(10)), ZL_FS, IL.Culture_Dish_Biomass_Flora.get(1));

        RM.Incubator.addRecipe1(T, 16, 2048, IL.Culture_Dish_Biomass_Flora.get(1), FL.AmylumSolution.make(1000), FL.BiomassFlora.make(1000), IL.Culture_Dish_Empty.get(1));

        RM.BioLab.addRecipeX(T, 128, 2000, ST.array(IL.Mixing_Rod.get(0), ST.tag(1)), FL.array(FL.BiomassFlora.make(1000)), FL.array(FL.Biowaste.make(900), FL.Yeast.make(1)), ZL_IS).setSpecialNumber(200000);

        RM.BioLab.addRecipeX(T, 128, 3000, ST.array(IL.Mixing_Rod.get(0), ST.tag(2)), FL.array(FL.BiomassFlora.make(1000), FL.Yeast.make(100), FL.Methane.make(1000)), FL.array(FL.Biowaste.make(900), FL.Methanogens.make(1)), ZL_IS).setSpecialNumber(200000);

        RM.BioLab.addRecipeX(T, 512, 4000, ST.array(IL.Mixing_Rod.get(0), ST.tag(3)), FL.array(FL.BiomassFlora.make(1000), FL.Methanogens.make(100), FL.Oxygen.make(1000)), FL.array(FL.Biowaste.make(900), FL.Bacillus.make(1)), ZL_IS).setSpecialNumber(200000);

        RM.BioLab.addRecipeX(T, 512, 4000, ST.array(IL.Mixing_Rod.get(0), ST.tag(4)), FL.array(FL.BiomassFlora.make(1000), FL.Bacillus.make(100), FL.Nitrogen.make(1000)), FL.array(FL.Biowaste.make(900), FL.Clostridia.make(1)), ZL_IS).setSpecialNumber(200000);

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.Yeast.make(10)), ZL_FS, IL.Culture_Dish_Yeast.get(1));

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.Methanogens.make(10)), ZL_FS, IL.Culture_Dish_Methanogens.get(1));

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.Bacillus.make(10)), ZL_FS, IL.Culture_Dish_Bacillus.get(1));

        RM.Injector.addRecipe1(T, 16, 512, IL.Culture_Dish_Empty.get(1), FL.array(FL.BacteriaMedium.make(1000), FL.Clostridia.make(10)), ZL_FS, IL.Culture_Dish_Clostridia.get(1));

        RM.Incubator.addRecipe1(T, 16, 1024, IL.Culture_Dish_Yeast.get(1), FL.AmylumSolution.make(1000), FL.Yeast.make(1000), IL.Culture_Dish_Empty.get(1));

        RM.Incubator.addRecipe1(T, 16, 2048, IL.Culture_Dish_Methanogens.get(1), FL.AmylumSolution.make(1000), FL.Methanogens.make(1000), IL.Culture_Dish_Empty.get(1));

        RM.Incubator.addRecipe1(T, 16, 2048, IL.Culture_Dish_Bacillus.get(1), FL.AmylumSolution.make(1000), FL.Bacillus.make(1000), IL.Culture_Dish_Empty.get(1));

        RM.Incubator.addRecipe1(T, 16, 2048, IL.Culture_Dish_Clostridia.get(1), FL.AmylumSolution.make(1000), FL.Clostridia.make(1000), IL.Culture_Dish_Empty.get(1));


        // Functions of bacteria
        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Yeast.make(1), FL.BiomassIC2.make(40)), FL.array(FL.BioEthanol.make(30)), ZL_IS);

        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Methanogens.make(1), FL.BiomassIC2.make(40)), FL.array(FL.Methane.make(10)), ZL_IS);

        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Bacillus.make(1), FL.BiomassIC2.make(40), MT.Air.fluid(U100, T)), FL.array(MT.H.fluid(U1000*15, T)), ZL_IS);

        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Bacillus.make(1), FL.BiomassIC2.make(40), MT.O.fluid(U100, T)), FL.array(MT.H.fluid(U100*3, T)), ZL_IS);

        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Clostridia.make(1), FL.BiomassIC2.make(40), MT.N.fluid(U100, T)), FL.array(MT.H.fluid(U100*2, T)), ZL_IS);

        RM.Incubator.addRecipe1(T, 16, 24, ST.tag(0), FL.array(FL.Clostridia.make(1), FL.BiomassIC2.make(40), MT.He.fluid(U100, T)), FL.array(MT.H.fluid(U100*4, T)), ZL_IS);

        // Bacteria ends

        RM.Sharpening.addRecipe1(T, 16, 128, OP.plate.mat(MT.GT6U.PTFE, 1), ZL_FS, ZL_FS, IL.Culture_Dish_Empty.get(1));
        //空培养皿的合成

        RM.Centrifuge.addRecipe1(T,1024,200, ST.make(Items.bone,1,0), ZL_FS, FL.BoneMarrow.make(1),OP.dust.mat(MT.Bone,4));
        //骨髓血

        RM.Mixer.addRecipe1(T,16,64,OP.dustDiv72.mat(MT.NaCl,81), MT.DistWater.liquid(U*125,T), FL.SPSS.make(125000),ZL_IS);
        RM.Mixer.addRecipe1(T,64,128,OP.dust.mat(MT.NaCl,9),MT.DistWater.liquid(U*1000,T), FL.SPSS.make(1000000),ZL_IS);
        RM.Mixer.addRecipe1(T,256,256,OP.dustSmall.mat(MT.NaCl, 9),MT.DistWater.liquid(U*250,T), FL.SPSS.make(250000),ZL_IS);
        //生理盐水

        RM.Welder.addRecipeX(T,256,256, ST.array(OP.plateTiny.mat(MT.Ti,4),OP.gearGtSmall.mat(MT.Ti,1),OP.stick.mat(MT.Ti, 2) , OP.stick.mat(MT.NeodymiumMagnetic,1), OP.stickLong.mat(MT.Rh,1),IL.Processor_Crystal_Emerald.get(1)) ,ZL_FS,ZL_FS,IL.Precision_Manipulator.get(1));
        //精密机械臂，晶体处理器要在MT中换成MF8

        RM.Mixer.addRecipeX(T, 64, 64, ST.array(OP.dustSmall.mat(MT.PO4 , 1) , OP.dustSmall.mat(MT.KNO3 , 1) , OP.dustSmall.mat(MT.CaSO4, 1), OP.dustSmall.mat(MT.MgCl2,1)),ZL_FS,ZL_FS, IL.dust_Inorganic_Salt_Mixture.get(1));
        //无机盐混合物粉

        CR.shaped(IL.dust_Tiny_Inorganic_Salt_Mixture.get(9),DEF , "X  ", 'X',IL.dust_Inorganic_Salt_Mixture);
        CR.shaped(IL.dust_Inorganic_Salt_Mixture.get(1),DEF_NCC, "XXX", "XXX" ,"XXX" , 'X', IL.dust_Tiny_Inorganic_Salt_Mixture.get(9));
        //无机盐混合物粉与其小撮粉的相互转化

        RM.Juicer.addRecipe1(T, 16, 114, ST.make(Items.ghast_tear, 1, 0), ZL_FS, FL.HormoneSolution.make(1), ZL_IS);
        RM.HeatMixer.addRecipe1(T, 256, 810, ST.make(Items.golden_apple, 8, 0), FL.HormoneSolution.make(8), FL.HormoneSolution.make(9), ZL_IS);
        //激素溶液

        RM.HeatMixer.addRecipeX(T, 16, 500, ZL_IS, FL.array(FL.AmylumSolution.make(2000), MT.SulfuricAcid.fluid(U10, T)), FL.Holywater.make(1000), IL.dust_Glucose.get(1));
        //葡萄糖

        RM.Mixer.addRecipeX(T, 16, 512, ZL_IS, FL.array(FL.Juice_Tomato.make(1000), MT.Ethanol.liquid(U, T)), FL.VitaminSolution.make(1), ZL_IS);
        //维生素溶液

        RM.CryoMixer.addRecipeX(T, 256, 514, ST.array(IL.dust_Glucose.get(1), IL.dust_Tiny_Inorganic_Salt_Mixture.get(1)) , FL.array(FL.SPSS.make(1000), FL.Protein.make(10), FL.VitaminSolution.make(1), FL.HormoneSolution.make(1)), FL.MSCBasalMedium.make(1000), ZL_IS);
        //干细胞无血清营养添加物

        RM.CryoMixer.addRecipeX(T, 64, 1919, ST.array(IL.dust_Glucose.get(4), IL.dust_Inorganic_Salt_Mixture.get(1)), FL.array(FL.SPSS.make(1000), FL.Protein.make(1000)), FL.MSCSupplement.make(1000), ZL_IS);
        //干细胞无血清基础培养基

        RM.BioLab.addRecipe1(T, 64, 512, new long[] {1000}, IL.Culture_Dish_Empty.get(1), FL.array(FL.MSCBasalMedium.make(1000), FL.BoneMarrow.make(1)), ZL_FS,IL.Culture_Dish_Stem_Cell_Embryonic.get(1)).setSpecialNumber(2000000);
        //接种干细胞
        RM.BioLab.addRecipe2(T, 64, 256, IL.Culture_Dish_Empty.get(4), IL.Stem_Cell.get(1), FL.MSCBasalMedium.make(1000), NF, IL.Culture_Dish_Stem_Cell_Embryonic.get(1)).setSpecialNumber(2000000);
        //还是接种干细胞

        RM.BioLab.addRecipe2(T, 16, 64, IL.Culture_Dish_Stem_Cell_Somatic.get(1), ST.tag(0), NF, NF, ST.array(IL.Stem_Cell.get(9), OP.scrapGt.mat(MT.GT6U.PTFE, 3)));
        //从培养完成的培养皿中提取干细胞

        RM.Incubator.addRecipe2(T, 16, 60000 + 4096, IL.Culture_Dish_Stem_Cell_Embryonic.get(1), ST.tag(1), FL.MSCSupplement.make(1000), NF, IL.Culture_Dish_Stem_Cell_Somatic.get(1));
        //培养干细胞

        RM.Distillery.addRecipe1(T, 512, 128,ST.tag(0), MT.Petrol.liquid(U, T), FL.Dodecane.make(150), ZL_IS);
        RM.Distillery.addRecipe1(T, 512, 192,ST.tag(0), MT.Diesel.liquid(U, T), FL.Dodecane.make(200), ZL_IS);
        //十二烷

        RM.Mixer.addRecipe0(T, 16, 256, FL.array(FL.Dodecane.make(10000), MT.Cl.gas(U, T)), FL.array(FL.Dodecane_Chloride.make(1000), FL.Dodecane.make(9000)), ZL_IS);
        RM.HeatMixer.addRecipe0(T, 256, 24, FL.array(FL.Dodecane.make(10000), MT.Cl.gas(U, T)), FL.array(FL.Dodecane_Chloride.make(1000),FL.Dodecane.make(9000)), ZL_IS);
        //氯化十二烷

        RM.Distillery.addRecipe1(T, 256, 256, ST.tag(0), FL.Dodecane_Chloride.make(1000), FL.Monochlorodecane.make(50), ZL_IS);
        //一氯十二烷。因为不再加入一氯十二烷提纯为1,一氯十二烷的操作，遂在此再次减小概率

        RM.HeatMixer.addRecipe1(T, 64, 256, OP.dust.mat(MT.NaOH, 1), FL.array(FL.Monochlorodecane.make(1000), MT.Water.liquid(U*2, T)), FL.LaurylAlcohol.make(1000), OP.dust.mat(MT.NaCl, 1));
        //月桂醇

        //RM.BioLab.addRecipe1(T, 16, 64, IL.USB_Stick_4.get(1), ZL_FS, ZL_FS, IL.USB_Stick_4.getWithName(1, "Gene Data"));
        //RM.BioLab.addRecipe1(T, 16, 64, IL.USB_Stick_4.get(1), ZL_FS, ZL_FS, IL.USB_Stick_4.getWithNameAndNBT(1, "Gene Data", UT.NBT.makeString("gt.gene", "Stem Cell")));

        /** DNA 提取 */
        RM.HeatMixer.addRecipeX(T, 512, 200, ZL_IS, FL.array(MT.CO.fluid(U, T), MT.H.fluid(U, T)), FL.array(FL.Methanol.make(1000)), ZL_IS);

        RM.HeatMixer.addRecipeX(T, 512, 200, ZL_IS, FL.array(FL.CoconutOil.make(1000), MT.H2SO4.fluid(U, T), FL.Methanol.make(3000)), FL.array(FL.MethylLaurate.make(3000), MT.Glycerol.fluid(U, T), MT.H2SO4.fluid(U10*9, T)), ZL_IS);

        RM.HeatMixer.addRecipe1(T, 512, 200, OP.dust.mat(MT.Pt, 0), FL.array(FL.MethylLaurate.make(1000), MT.H.fluid(U*2, T)), FL.array(FL.MethylHydrolaurate.make(1000)), ZL_IS);

        RM.Distillery.addRecipe1(T, 256, 2000, ST.tag(0), FL.array(FL.MethylHydrolaurate.make(1000)), FL.array(FL.LaurylAlcohol.make(1000)), ZL_IS);

        RM.HeatMixer.addRecipe0(T, 512, 200, FL.array(FL.LaurylAlcohol.make(1000), MT.N.fluid(U, T), MT.SO3.fluid(U, T)), ZL_FS, IL.Lauryl_Sulfate.get(1));

        RM.HeatMixer.addRecipeX(T, 512, 200, ST.array(IL.Lauryl_Sulfate.get(1), OP.dust.mat(MT.NaOH, 2)), ZL_FS, ZL_FS, ST.array(IL.SDS.get(1), OP.dust.mat(MT.NaSO4, 1)));

        RM.HeatMixer.addRecipe1(T, 512, 200, ST.tag(0), FL.array(MT.Butane.fluid(U, T), MT.DistWater.fluid(U*3, T), MT.HNO3.fluid(U, T), MT.HCl.fluid(U, T)), FL.Tris_HCl.make(1000), ZL_IS);

        RM.HeatMixer.addRecipe0(T, 128, 200, FL.array(MT.Ethylene.fluid(U, T), MT.Water.fluid(U, T)), FL.array(MT.Ethanol.fluid(U, T)), ZL_IS);

        RM.HeatMixer.addRecipe1(T, 512, 200, OP.spring.mat(MT.Silver, 0), FL.array(MT.Ethanol.fluid(U, T)), FL.array(FL.AceticAcid.make(1000)), ZL_IS);

        RM.HeatMixer.addRecipe0(T, 512, 200, FL.array(MT.Ethylene.fluid(U, T), MT.Br.fluid(U, T), MT.NH3.fluid(U*2, T), FL.AceticAcid.make(4000)), FL.array(FL.EDTA.make(1000)), ZL_IS);

        RM.CryoMixer.addRecipe1(T, 16, 200, IL.Unformed_Embryo.get(1), FL.array(MT.Ethanol.fluid(U, T)), FL.array(FL.AnimalTissueHomogenate.make(1000)), ZL_IS);

        RM.Mixer.addRecipe1(T, 64, 200, IL.SDS.get(1), FL.array(FL.AnimalTissueHomogenate.make(1000), FL.EDTA.make(1000), FL.Tris_HCl.make(1000)), FL.array(FL.DNAExtract.make(1000)), ZL_IS);

        RM.CryoMixer.addRecipe0(T, 64, 200, FL.array(FL.DNAExtract.make(1000), MT.Ethanol.fluid(U, T)), FL.array(FL.DNASolution.make(1000)), ZL_IS);

        /**DNA提取部分结束*/

        RM.HeatMixer.addRecipe1(T, 64, 2048, OP.dust.mat(MT.NaOH, 0), FL.DNASolution.make(1000), FL.Deoxyribonucleotide.make(1000), ZL_IS);
        //脱氧核糖核苷酸

        RM.HeatMixer.addRecipe1(T, 64, 512, dustTiny.mat(MT.NaOH, 0), FL.DNASolution.make(1000), FL.Primer.make(100), ZL_IS);
        //引物

        RM.BioLab.addRecipe0(T, 16, 4096, MT.Lava.liquid(U*16, T), FL.taqDNAPolymerase.make(1), ZL_IS).setSpecialNumber(200000);;
        //taqDNA聚合酶

        RM.BioLab.addRecipeX(T, 64, 8192, ST.array(IL.Culture_Dish_Empty.get(1), OP.ingot.mat(MT.MeatCooked, 1), ST.make(Blocks.dirt, 1, 0)), MT.Water.liquid(U, T), FL.EscherichiaColi.make(1) , ZL_IS).setSpecialNumber(200000);;
        //大肠杆菌

        RM.Incubator.addRecipe1(T, 16, 32768, OP.ingot.mat(MT.MeatCooked, 4), FL.EscherichiaColi.make(1), FL.EscherichiaColi.make(1000), ZL_IS);
        //培养大肠杆菌

        RM.BioLab.addRecipe1(T, 256, 4096, ST.tag(0), FL.EscherichiaColi.make(1000), FL.RestrictionEndonuclease.make(1), ZL_IS);
        //提取限制性核酸内切酶

        RM.BioLab.addRecipe1(T, 16, 1024, new long[]{100}, OP.tube.mat(MT.Glass, 1), FL.array(FL.DNASolution.make(1), FL.RestrictionEndonuclease.make(1)), ZL_FS, IL.Gene_Samples.getWithNameAndNBT(1, "Gene Data", UT.NBT.makeString("gt.gene", "Differentiation promoting protein (nerve cell)"))).setSpecialNumber(200000);;
        //基因样本

        RM.BioLab.addRecipe1(T, 64, 1024, IL.Gene_Samples.getWithNameAndNBT(1, "Gene Data", UT.NBT.makeString("gt.gene", "Differentiation promoting protein (nerve cell)")), FL.array(FL.Primer.make(100), FL.Deoxyribonucleotide.make(1000)), FL.DifferentiationPromotingProtein_NerveCell_Gene.make(100), ZL_IS).setSpecialNumber(200000);;
        //扩增基因样本

        RM.BioLab.addRecipe1(T, 16, 256, OP.dust.mat(MT.CaCl2, 1), FL.array(FL.DifferentiationPromotingProtein_NerveCell_Gene.make(1000), FL.EscherichiaColi.make(10)), FL.Bacteria_DifferentiationPromotingProteinNeuron.make(1), ZL_IS).setSpecialNumber(200000);;
        //导入基因。本来要用林业那个附属的基因的，但是这里没有，但是正好加了大肠杆菌，就用了，也挺好

        RM.Incubator.addRecipe1(T, 16, 32768, ST.tag(0),  FL.array(FL.Bacteria_DifferentiationPromotingProteinNeuron.make(1),FL.MSCSupplement.make(1000)), FL.Bacteria_DifferentiationPromotingProteinNeuron.make(100), ZL_IS);
        //培养导入基因后的细菌

        RM.Centrifuge.addRecipe0(T, 256, 512, FL.Bacteria_DifferentiationPromotingProteinNeuron.make(100), FL.DifferentiationPromotingProteinNeuron.make(10), ZL_IS);
        //提取促分化蛋白

        RM.BioLab.addRecipe1(T, 16, 256, new long[]{1000}, ST.make(Items.egg, 1, 0), ZL_FS, ZL_FS, IL.Unformed_Embryo.get(1)).setSpecialNumber(200000);;
        //从鸡蛋里拿出未成形胚胎

        RM.BioLab.addRecipe1(T, 16, 16384, new long[]{5000}, IL.Culture_Dish_Stem_Cell_Somatic.get(1), FL.DifferentiationPromotingProteinNeuron.make(10), NF, IL.Neuron_Cell.get(1)).setSpecialNumber(200000);;
        //神经细胞培养皿

    }

}


//给鸭蛋的加配方介绍：

//初级
//RM.Sharpening 相当于mtu keys
//addRecipe1 输入一种物品的配方 addRecipe2 输入两种物品的配方，addRecipeX 输入大于2种物品的配方
//ST.tag(1) 是集成电路 数字代表集成电路编号
//aEUt 表示能量需求
//aDuration 表示时长
//这里之后可以选用加一个 new long[] {10000, 2000} 之类的，代表输出物品的几率。同mtu
//然后参数就是MTU里一样的顺序的：输入物品（或物品数组）输入流体（或流体数组）输出流体（或流体数组）输出物品（或物品数组）

//中级：
//无论是物品还是流体，输入还是输出，如果大于一种：物品必须要用ST.array(物品1，物品2)，流体要用FL.array(流体1，流体2)
//若输入/输出为空：物品用ZL_IS代替，流体用ZL_FS代替
//物品表示方法：IL.物品名.get(数量) 或者 OP.<板/锭/粉/小粉/等等的标志，可以打完OP.自己翻，多试试就懂>.mat(MT.材料名, 数量)
//流体表示方法：FL.流体名.make(一个整数，升为单位) 或者 MT.材料名.liquid/gas/fluid(U*份数，T或者F) U一般对于流体代表1000L，U10代表U/10，U100代表U/100，以此类推。 T代表这个流体是输入，F代表这个流体是输出，非常重要！！
//RM.BioLab.addRecipe1(T, 16, 64, IL.USB_Stick_4.get(1), ZL_FS, ZL_FS, IL.USB_Stick_4.getWithNameAndNBT(1, "Gene Data", UT.NBT.makeString("gt.gene", "Stem Cell")));
//上为NBT添加方法
