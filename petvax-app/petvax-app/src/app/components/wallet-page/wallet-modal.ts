export interface Wallets {
    id: number;
    name: string;
    purpose: string;
    vaccines: Vaccine[];
}

interface Vaccine {
  id: number;
  name: string;
  provider: string;
  date: Date;
}