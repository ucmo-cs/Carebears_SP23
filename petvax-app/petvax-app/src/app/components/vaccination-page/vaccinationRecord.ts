export interface VaccinationRecord {
    vaccination: {
      vaccinationId: string;
      name: string;
      type: string;
      age: string;
      frequency: string;
      species: string;
      createdDate: string;
    };
    vaccinationDate: string;
    provider: {
      uuid: string;
      name: string;
      address1: string;
      address2: string | null;
      city: string;
      state: string;
      zipCode: string;
      email: string;
      createdDate: string;
    };
    active: boolean;
  }
  