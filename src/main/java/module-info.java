module fr.kenlek.j4p
{
    requires jdk.hotspot.agent;

    requires transitive fr.kenlek.jpgen.api;

    exports fr.kenlek.j4p;
    exports fr.kenlek.j4p.awt;
}
