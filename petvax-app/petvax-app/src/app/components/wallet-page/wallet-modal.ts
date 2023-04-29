export interface Wallets {
    id: number;
    name: string;
    purpose: string;
    vaccines: Vaccine[];
}

export interface Vaccine {
  id: number;
  name: string;
  provider: string;
  date: Date;
}