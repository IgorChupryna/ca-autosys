package ua.chup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.chup.model.Util;
import ua.chup.service.UtilService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public CommandLineRunner demo(final UtilService utilService) {
        return new CommandLineRunner(){

            @Override
            public void run(String... strings) throws Exception {
                Util util;
                for (int i = 0; i < 13; i++) {
                    util = new Util("Nmae"+i,"descCA WAAE Report Utility\n" +
                            "\n" +
                            "USAGE: autorep [-J JobName] [[-d | -s] [-n | -w] [-R RunNumber] | -o OverRideNumber | -q] [-L PrintLevel] [-t]\n" +
                            "               [-I ApplicationName] [-B GroupName] [[-d | -s] [-n | -w] | -o OverRideNumber | -q] [-L PrintLevel] [-t]\n" +
                            "               [-G GlobalName] [-n | -w]\n" +
                            "               [-M MachineName] [[-d | -s] [-n | -w] | -p | -q]\n" +
                            "               [-C ConnectionProfileName] [-q]\n" +
                            "               [-Q JobName] [-n]\n" +
                            "               [-V ResourceName] [[-d | -s] [-n | -w] | -q]\n" +
                            "               [-X ExternalInstanceName] [[-n | -w] | -q]\n" +
                            "               [-Y UserDefinedJobType] [[-n | -w] | -q]\n" +
                            "               [-z GlobalBlobName] [[-f BlobDownloadDirectory] [-a] | [-n | -w] | -q]\n" +
                            "               [-usr AuthUser [-pw AuthPassword | -pwx AuthEncryptedPassword] | -saml AuthArtifact]\n" +
                            "               [-x]\n" +
                            "               [-?]\n" +
                            "\n" +
                            "WHERE: -J    JobName\n" +
                            "       -I    ApplicationName\n" +
                            "       -B    GroupName\n" +
                            "       -o    OverRideNumber\n" +
                            "       -X    ExternalInstanceName\n" +
                            "       -Y    UserDefinedJobType\n" +
                            "       -z    GlobalBlobName\n" +
                            "       -G    GlobalName\n" +
                            "       -M    MachineName\n" +
                            "       -C    ConnectionProfileName\n" +
                            "       -V    ResourceName\n" +
                            "       -Q    JobName                    Generates a detail report on the jobs that are stuck either in QUE_WAIT or RESWAIT status\n" +
                            "       -d                               Generates a detail report\n" +
                            "       -s                               Generates a summary report\n" +
                            "       -q                               Generates a query report (Jil format)\n" +
                            "       -p                               Generates an agent version, plug-in and advanced integrations report\n" +
                            "       -w                               Reports names using the long form (wide)\n" +
                            "       -n                               Reports truncated names (narrow)\n" +
                            "       -t                               Includes the timezone in the report\n" +
                            "       -R    RunNumber                  Generates the report for the job run\n" +
                            "                                        specified in run_num\n" +
                            "       -L    PrintLevel                 Generated Box Job hierarchy report will be\n" +
                            "                                        limited to level specified\n" +
                            "       -f    BlobDownloadDirectory      Blob data download location\n" +
                            "       -a                               Download blob data to file as ASCII text\n" +
                            "       -usr  AuthUser                   User to authenticate with external security\n" +
                            "       -pw   AuthPassword               Plain text password for user authentication\n" +
                            "       -pwx  AuthEncryptedPassword      Encrypted password for user authentication\n" +
                            "       -saml AuthArtifact               Security Assertion Markup Language (SAML) artifact\n" +
                            "                                        for single sign-on authentication\n" +
                            "       -x                               Returns version information\n" +
                            "       -?                               Help\n" +
                            "\n" +
                            "NOTE:  1. -J OR -M OR -G OR -B OR -I OR -X OR -Y OR -V OR -Q are required parameters.\n" +
                            "       2. If OverRideNumber = 0, it will display override number currently in effect.\n" +
                            "       3. If both [-B GroupName] and [-I ApplicationName] attributes\n" +
                            "          are specified, this is treated as an AND condition.\n" +
                            "       4. [-J JobName] and [-B GroupName or -I ApplicationName][-X]\n" +
                            "          are mutually exclusive.\n" +
                            "       5. The [-a] and/or [-f] attributes are valid with the attribute\n" +
                            "          pair [-J JobName] and [-q] or with the [-z GlobalBlobName] attribute"+i,"example"+i,"path"+i);
                    utilService.addUtil(util);
                }

            }
        };
    }
 }