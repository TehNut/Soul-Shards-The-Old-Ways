package com.whammich.sstow.compat.waila.provider;

import com.whammich.sstow.tile.TileEntityCage;
import com.whammich.sstow.util.Utils;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import tehnut.lib.util.TextHelper;

import java.util.List;

public class DataProviderCage implements IWailaDataProvider {

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        if (accessor.getPlayer().isSneaking()) {
            if (accessor.getTileEntity() != null && accessor.getTileEntity() instanceof TileEntityCage) {
                TileEntityCage cage = (TileEntityCage) accessor.getTileEntity();

                if (cage.getStackInSlot(0) != null) {
                    ItemStack shardStack = cage.getStackInSlot(0);
                    currenttip.add(String.format("Spawning: %s", Utils.getShardBoundEnt(shardStack)));
                    currenttip.add(String.format("Tier: %d", Utils.getShardTier(shardStack)));
                    currenttip.add(String.format("Kills: %d", Utils.getShardKillCount(shardStack)));
                }
            }
        } else {
            currenttip.add(TextHelper.localizeEffect("waila.SoulShardsTOW.sneak"));
        }

        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
        return null;
    }
}
