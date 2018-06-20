package Study.jdk8;

public class JDK8InterfaceImpl implements JDK8Interface1, JDK8Interface2 {

    private JDK8Interface1 jdk8Interface1;

    public JDK8InterfaceImpl() {
    }

    public JDK8InterfaceImpl(JDK8Interface1 interface1) {
        jdk8Interface1 = interface1;
    }

    @Override
    public void help() {
        if (jdk8Interface1 != null)
            jdk8Interface1.help();
    }
}
