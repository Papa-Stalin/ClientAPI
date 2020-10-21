package cat.yoink.clientapi.module;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.component.Component;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ModuleManager
{
    private final ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager()
    {
        for (Class<?> aClass : new Reflections(ClientAPI.getMasterPackage() == null ? "" : ClientAPI.getMasterPackage().getName()).getSubTypesOf(Module.class))
        {
            try { modules.add((Module) aClass.getConstructor().newInstance()); }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (Component component : ClientAPI.getComponentManager().getComponents())
        {
            if (getModule(component.getName()) == null)
            {
                try { modules.add(new ModuleBuilder().withName(component.getName()).withCategory(Category.HUD).build()); }
                catch (ModuleException e) { e.printStackTrace(); }
            }
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

    public ArrayList<Module> getModules(Category category)
    {
        return getModules().stream().filter(module -> module.getCategory().equals(category)).collect(Collectors.toCollection(ArrayList::new));
    }
}
