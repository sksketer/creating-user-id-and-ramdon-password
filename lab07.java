public class User {

    private String name;
    private String companyName;
    private int yearOfJoining;
    private String email;
    private String password;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String companyName, int yearOfJoining)     //  choice depends on user
    {
        this.name = name;
        this.companyName = companyName;
        this.yearOfJoining = yearOfJoining;
        this.email = createUserEmail();
        this.password = createUserPassword();

    }

    private String createUserEmail() {
        return String.format("%s_d@%s.com", getName(), getYearOfJoining(), getCompanyName());
    }

    private String createUserPassword() {
        StringBuilder sb = new StringBuilder();  // string immutable
        sb.append(generateRandomCharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomIntegerFromLimit(10));

        }
        sb.append(getFirst5CharactersFromUserName());
        sb.append(generateRandomSpecialSymbol());


        return sb.toString();

    }

    public int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }

    private char generateRandomCharacter() {
        int randomNumberupto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberupto26);
    }

    private String getFirst5CharactersFromUserName() {
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");


            }
            return tempName.toString();
        } else
            return getName().substring(0, 5);
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols =
                {
                        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', '|', '\\', ':', ';', '?', '.', '<', '>'
                };
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }


}
class UserEntry
{
    public static void main(String[] args) {
        User obj =new User("sketeramrit","Adobe",2025);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}
