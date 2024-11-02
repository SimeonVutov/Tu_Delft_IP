public enum Rarity {
    NORMAL {
        /**
         * Creates a text representation of the object
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return "Normal";
        }
    },
    EPIC {
        /**
         * Creates a text representation of the object
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return "Epic";
        }
    },
    RARE {
        /**
         * Creates a text representation of the object
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return "Rare";
        }
    },
    LEGENDARY {
        /**
         * Creates a text representation of the object
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return "Legendary";
        }
    };
}
