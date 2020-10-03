package cat.yoink.clientapi.module;

import org.reflections.Reflections;

import java.util.ArrayList;

public class ModuleManager
{
    private final ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager()
    {
        for (Class<?> aClass : new Reflections("").getSubTypesOf(Module.class))
        {
            try { modules.add((Module) aClass.getConstructor().newInstance()); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public Module getModule(String name)
    {
        for (Module module : modules)
        {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public ArrayList<Module> getEnabledModules()
    {
        ArrayList<Module> mods = new ArrayList<>();
        for (Module module : modules)
        {
            if (module.isEnabled()) mods.add(module);
        }
        return mods;
    }

    public ArrayList<Module> getModules()
    {
        return modules;
    }
}
