<h1 align="center">ClientAPI</h1>      
  
<h4 align="center"> ClientAPI is an easy-to-use Minecraft Forge utility client API for 1.12.2</h4>  

<p align="center">
  <img src="https://app.codacy.com/project/badge/Grade/a44d9c884565406e909a449706a73e2d" />
</p>

## Setting up

ClientAPI uses [Reflections](https://github.com/ronmamo/reflections) to automatically find classes used by your client. You might have to add it to your `gradle.build` with:  

```gradle  
compile(group: 'org.reflections', name: 'reflections', version: '0.9.11') 
{  
    exclude group: 'com.google.guava', module: 'guava'
}  
```  
  
  
### Setting up ClientAPI  

- Clone the repository with `git clone https://github.com/Katatje/ClientAPI.git`  
- Copy `cat.yoink.clientapi` to your own client. (Make sure not to include `cat.yoink.example`)  
- Check if everything builds fine.  
  
  
## Getting started  

Start by creating a `ClientAPI` object. This can be done via the `APIBuilder` class. The `Name`, `ModID` and `Version` are required. Then, initialize the `API` we just created. This will load all the things needed for your client to work. After that we can load a config so all our previously saved settings are back from our last session.  


**Example:**

```java
@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.VERSION)
public class Client
{
    public static final String MOD_ID = "client";
    public static final String MOD_NAME = "Client";
    public static final String VERSION = "1";
    
    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) throws InitializationException 
    {
        ClientAPI api = new APIBuilder()
            .withName(MOD_NAME)
            .withModID(MOD_ID)
            .withVersion(VERSION)
            .withPrefix("-")
            .withLoggerPrefix("[ClientName]")
            .withFolderName("MyClient")
            .build();
        
        api.initialize();
        api.loadConfig(); 
    }
}  
```

## Creating a module

First, create a new class for your module and make it extend `Module`. Then, annotate the class with the `@Mod` annotation. This can take a `name`, `category`, `Description`, `Bind` and `Visible`. The `Name` and `Category` are required.  
  
  
**Example:**  

```java  
@Mod(name = "Sample", category = Category.MISC, description = "Demonstration module", bind = Keyboard.KEY_R)
public class SampleModule extends Module
{

}
```  
After that, we can create methods for our module. ClientAPI comes with a default `onEnable` and `onDisable` override classes. You can also use MinecraftForge's default Event System. For SubscribeEvents, I suggest you use `if (nullCheck()) return;` to prevent `NullPointerExceptions`.


**Example:**

```java  
@Mod(name = "Sample", category = Category.MISC, description = "Demonstration module", bind = Keyboard.KEY_R)
public class SampleModule extends Module
{
    @Override public void onEnable()
    {  
        System.out.println("Enabled!");
    }
    
    @Override
    public void onDisable()
    {
        System.out.println("Disabled!");
    }  
 
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    { 
        if (nullCheck()) return;
        
        System.out.println(event.getEntity().getName() + " just died!");
    }
}  
```  

To create settings, you have to create a `Setting` object. This can be done through the `SettingBuilder` class. There are 5 types of settings `Boolean`, `Integer`, `Float`, `Enum` and `Color`.  
  
  
**Example:**  

```java  
@Mod(name = "Sample", category = Category.MISC, description = "Demonstration module", bind = Keyboard.KEY_R)
public class SampleModule extends Module
{
    private final Setting booleanSetting = new SettingBuilder(SettingType.BOOLEAN).withName("SampleBooleanSetting!").withModule(this).withBooleanValue(true).build();
    private final Setting integerSetting = new SettingBuilder(SettingType.INTEGER).withName("SampleIntegerSetting!").withModule(this).withIntegerValue(5).withMaxIntegerValue(0).withMaxIntegerValue(10).build();
    private final Setting floatSetting = new SettingBuilder(SettingType.FLOAT).withName("SampleFloatSetting!").withModule(this).withFloatValue(3.14f).withMinFloatValue(2.48f).withMaxFloatValue(43.43f).build();
    private final Setting enumSetting = new SettingBuilder(SettingType.ENUM).withName("SampleEnumSetting!").withModule(this).withEnumValue("Test1").addEnumValue("Test0").addEnumValue("Test1").addEnumValue("Test2").addEnumValue("Test3").build();
    private final Setting colorSetting = new SettingBuilder(SettingType.COLOR).withName("SampleColorSetting!").withModule(this).withColor(Color.YELLOW).build();
  
    @Override
    public void onEnable()    
    {    
        System.out.println(booleanSetting.getBooleanValue());
        System.out.println(integerSetting.getIntegerValue());
        System.out.println(floatSetting.getFloatValue());
        System.out.println(enumSetting.getEnumValue());
        System.out.println(colorSetting.getColor().toString());
    }
}  
```  

## Creating a command  
Similar to a module, we first have to create a class and extend it from the  `Command` class. Then, we have to annotate it with `@Com`. This takes a `name`, `alias(es)`, `usage` and `description`. The alias is what triggers a command.  
  
  
**Example:**  

```java  
@Com(name = "Prefix", aliases = { "prefix" }, usage = "prefix <character>")  
public class Prefix extends Command  
{  
  
}  
``` 

Then, to make the command work, we have to override the `onRun` method. Once a command is ran, this function will be executed. You can also call `printUsage()` which sends the usage of the command in the chat.  
  
**Example:**  
```java  
@Com(name = "Prefix", aliases = { "prefix" }, usage = "prefix <character>")
public class Prefix extends Command
{    
    @Override
    public void onRun(String arguments)
    {
        if (arguments.equals("")) 
        {
            printUsage();
            return;
        }
        
        ClientAPI.setCommandPrefix(arguments);
        LoggerUtil.sendMessage("Prefix set to " + arguments);
    }
}  
```  
## Creating a HUD Component  

To create a HUD Component, first we have to create a new class and extend it from the `Component` class. Then, we have to annotate it with `@HUD`. This takes a `name`, `x`, `y`, `width`, `height` and `draggable`. The `name` is required. If you don't specify the `width` and `height` you might have to manually specify it using `setW()` and `setH()`. Then, to make the component render something, we have to override the `render()` method. 

**Example:**

```java
@HUD(name = "Watermark")
public class Watermark extends Component
{
    @Override
    public void render()
    {
        mc.fontRenderer.drawStringWithShadow(ClientAPI.getName(), getX(), getY(), -1);
        setW(mc.fontRenderer.getStringWidth(ClientAPI.getName()));
        setH(mc.fontRenderer.FONT_HEIGHT);
    }
}
```
  
## Utilities  
**ClientAPI** comes with a few useful utilities you can use.   
  
- `FileUtil` Allows you to easily create and read files from disk.  
- `LoggerUtil` Allows you to print out chat messages.  
- `PlayerUtil` Allows you to get information about your player.  
- `RenderUtil` Allows you to highlight things in your world.  
- `WorldUtil` Allows you to place blocks in your world.  
  
## Todo  
  
- ClickGUI API
