package TestPartition;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = "--bootstrap.servers",
               required = true,
               description = "Set bootstrap.servers to consumer")
    public String bootstrapServer;

    @Parameter(names = "--group",
               required = true,
               description = "Set group.id")
    public String groupID;

    @Parameter(names = "--strategy",
               required = true,
               description = "Set partition assignment strategy")
    public String partitionStrategy;

    public static Args parse(String[] args){
        Args arg = new Args();
        JCommander.newBuilder()
                  .addObject(arg)
                  .build()
                  .parse(args);
        return arg;
    }
}
