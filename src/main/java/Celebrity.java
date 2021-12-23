import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Celebrity {

    @RequiredArgsConstructor
    @EqualsAndHashCode
    static class Person {
        private final int ident;
        private List<Person> knowsPeople = new ArrayList<>();

        public boolean isKnownPerson(Person person) {
            return this.equals(person) ? true : knowsPeople.contains(person);
        }

        public boolean addKnownPerson(Person person) {
            return knowsPeople.add(person);
        }
    }

    public static Optional<Person> findCelebrity(List<Person> persons) {
        if (persons.isEmpty() || persons.size() == 1)
            throw new IllegalArgumentException("List must contain more than 1 person");

        List<Person> potentialCelebrities = persons;
        while (potentialCelebrities.size() != 1) {
            List<Person> currentCandidates = new ArrayList<>();
            for (int i = 0; i < potentialCelebrities.size(); i += 2) {
                if (i + 1 < potentialCelebrities.size()) {
                    Optional.ofNullable(checkPotentialCelebrity(potentialCelebrities.get(i), potentialCelebrities.get(i + 1)))
                            .ifPresent(cel -> currentCandidates.add(cel));
                } else {
                    currentCandidates.add(potentialCelebrities.get(i));
                }
            }
            potentialCelebrities = currentCandidates;
            if (potentialCelebrities.size() == 0) return Optional.empty();
        }

        Person potentialCelebrity = potentialCelebrities.get(0);
        for (int i = 0; i < persons.size(); i++) {
            if (!persons.get(i).isKnownPerson(potentialCelebrity)) {
                return Optional.empty();
            }
        }
        for (int i = 0; i < persons.size(); i++) {
            if (!potentialCelebrity.equals(persons.get(i)) && potentialCelebrity.isKnownPerson(persons.get(i))) {
                return Optional.empty();
            }
        }

        return Optional.of(potentialCelebrity);
    }

    private static Person checkPotentialCelebrity(Person first, Person second) {
        Person potentialCelebrity = first.isKnownPerson(second) ? second : first;
        Person notCelebrity = potentialCelebrity.equals(first) ? second : first;
        if (potentialCelebrity.isKnownPerson(notCelebrity)) {
            potentialCelebrity = null;
        }
        return potentialCelebrity;
    }


    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        // person4 - знаменитость
        person1.addKnownPerson(person2);
        person1.addKnownPerson(person3);
        person1.addKnownPerson(person4);
        person2.addKnownPerson(person4);
        person2.addKnownPerson(person1);
        person3.addKnownPerson(person1);
        person3.addKnownPerson(person2);
        person3.addKnownPerson(person4);
        person5.addKnownPerson(person4);
        person5.addKnownPerson(person1);

        Optional<Person> celebrity = findCelebrity(Stream.of(person1, person2, person3, person4, person5).collect(Collectors.toList()));
    }
}
