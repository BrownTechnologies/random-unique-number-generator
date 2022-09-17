package in.browntechnologies;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    private Set set = new HashSet<BigInteger>();
    private String flag = mostSignificantCounter();

    private String mostSignificantCounter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return new StringBuilder()
                .append((localDateTime.getYear() + "").substring(2))
                .append(localDateTime.getDayOfYear())
                .append(localDateTime.getHour())
                .append(localDateTime.getMinute())
                .append(localDateTime.getSecond())
                .toString();
    }

    private String leastSignificantCounter() {
        Random random = new Random(LocalDateTime.now().getNano());
        Integer rId = (1 + random.nextInt(10) * 10000) + random.nextInt(10000);
        return String.format("%05d", rId);
    }

    public BigInteger uniqueRandomBigInt() {
        String msc = mostSignificantCounter();
        BigInteger uniqueBigIntId = new BigInteger(msc + leastSignificantCounter());
        if (set.contains(uniqueBigIntId)) {
            return uniqueRandomBigInt();
        } else {
            if (!flag.equals(msc)) {
                set.clear();
                flag = msc;
            }
            set.add(uniqueBigIntId);
            return uniqueBigIntId;
        }
    }
}
