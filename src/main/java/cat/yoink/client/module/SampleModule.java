package cat.yoink.client.module;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.event.ChatMessageSendEvent;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Mod;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import cat.yoink.clientapi.setting.SettingBuilder;
import cat.yoink.clientapi.setting.SettingType;
import cat.yoink.clientapi.util.LoggerUtil;
import cat.yoink.clientapi.util.RenderUtil;
import cat.yoink.clientapi.util.WorldUtil;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;

@Mod(name = "Sample", category = Category.MISC, description = "Demonstration module", bind = Keyboard.KEY_R)
public class SampleModule extends Module
{
    Setting booleanSetting = new SettingBuilder(SettingType.BOOLEAN).withName("SampleBooleanSetting!").withModule(this).withBooleanValue(true).build();
    Setting integerSetting = new SettingBuilder(SettingType.INTEGER).withName("SampleIntegerSetting!").withModule(this).withIntegerValue(5).withMaxIntegerValue(0).withMaxIntegerValue(10).build();
    Setting floatSetting = new SettingBuilder(SettingType.FLOAT).withName("SampleFloatSetting!").withModule(this).withFloatValue(3.14f).withMinFloatValue(2.48f).withMaxFloatValue(43.43f).build();
    Setting enumSetting = new SettingBuilder(SettingType.ENUM).withName("SampleEnumSetting!").withModule(this).withEnumValue("Test1").addEnumValue("Test0").addEnumValue("Test1").addEnumValue("Test2").addEnumValue("Test3").build();
    Setting colorSetting = new SettingBuilder(SettingType.COLOR).withName("SampleColorSetting!").withModule(this).withColor(Color.YELLOW).build();

    @Override
    public void onEnable()
    {
        LoggerUtil.sendMessage("Enabled!");

        LoggerUtil.sendMessage(String.valueOf(booleanSetting.getBooleanValue()));
    }

    @Override
    public void onDisable()
    {
        LoggerUtil.sendMessage("Disabled!");

        LoggerUtil.sendMessage(String.valueOf(booleanSetting.getBooleanValue()));

        booleanSetting.setBooleanValue(!booleanSetting.getBooleanValue());

        WorldUtil.placeBlock(mc.player.getPosition().north(3));
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (nullCheck()) return;

        LoggerUtil.sendMessage(event.getEntity().getName() + " just died!");
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event)
    {
        if (nullCheck()) return;

        RenderUtil.drawBoxFromBlockpos(mc.player.getPosition().down(2), 0.7f, 0.2f, 0.2f, 0.5f);
    }

    @SubscribeEvent
    public void onChatMessageSend(ChatMessageSendEvent event)
    {
        if (nullCheck() || event.getMessage().startsWith("/")) return;

        event.setMessage(event.getMessage() + " | " + ClientAPI.getName());
    }
}
