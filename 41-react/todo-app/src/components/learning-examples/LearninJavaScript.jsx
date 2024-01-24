const person = {
    name: 'Anand',
    address: {
        line1: 'Village Pata',
        district: 'Auraiya',
        country: 'India'
    },
    profiles: ['twitter', 'LinkedIn', 'instagram'],
    printProfiles: () => {
        person.profiles.map(
            profile => {
                console.log(profile)
            }
        )

        // console.log(person.profiles[0])
    }
}

export default function LearningJavaScript(){
    return (
        <>
            <div>Learning JavaScript <br></br> {person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfiles()}</div>
        </>
    )
}