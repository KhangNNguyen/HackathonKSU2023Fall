// JavaScript code

// Function to create a new container

// Define the Container constructor
function Container(width, height, length, maxWeight) {
    this.width = width;
    this.height = height;
    this.length = length;
    this.maxWeight = maxWeight;
    this.currentWeight = 0.0;
    this.items = [];

    // Method to check if an item can fit in the container
    this.canFitItem = function (item) {
        return (
            this.width >= item.width &&
            this.height >= item.height &&
            this.length >= item.length &&
            this.currentWeight + item.weight * item.quantity <= this.maxWeight
        );
    };

    // Method to add an item to the container
    this.addItem = function (item) {
        this.items.push(item);
        this.currentWeight += item.weight;
        this.width -= item.width * item.quantity;
        this.height -= item.height * item.quantity;
        this.length -= item.length * item.quantity;

        // Ensure dimensions are not negative
        if (this.width < 0) {
            this.width = 0;
        }
        if (this.height < 0) {
            this.height = 0;
        }
        if (this.length < 0) {
            this.length = 0;
        }
    };
}

function createContainer() {
    const width = parseFloat(document.getElementById("width").value);
    const height = parseFloat(document.getElementById("height").value);
    const length = parseFloat(document.getElementById("length").value);
    const maxWeight = parseFloat(document.getElementById("maxWeight").value);

    if (isNaN(width) || isNaN(height) || isNaN(length) || isNaN(maxWeight)) {
        alert("Please enter valid container dimensions and max weight.");
        return;
    }

    // Create a new container object and add it to the list
    const container = new Container(width, height, length, maxWeight);

    // Check if there's enough space in the container
    if (!container.canFitItem(new Item("", width, height, length, maxWeight, false, 1))) {
        alert("Not enough space in the container for the initial item.");
        return;
    }

    containers.push(container);

    // Display the new container in the list
    displayContainers();

    // Clear the input fields
    document.getElementById("width").value = "";
    document.getElementById("height").value = "";
    document.getElementById("length").value = "";
    document.getElementById("maxWeight").value = "";
}



// Define the Item constructor
function Item(name, width, height, length, weight, hazardous, quantity) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.length = length;
    this.weight = weight * quantity;
    this.hazardous = hazardous;
    this.quantity = quantity;
}

function addPresetItem() {
    const selectedItem = document.getElementById("presetItems").value;
    const quantity = parseInt(document.getElementById("quantity").value);

    if (isNaN(quantity) || quantity <= 0) {
        alert("Please enter a valid quantity.");
        return;
    }

    const selectedPresetItem = presetItems.find(item => item.name === selectedItem);

    if (!selectedPresetItem) {
        alert("Invalid preset item selected.");
        return;
    }

    // Create a new item object based on the selected preset item
    const newItem = new Item(
        selectedPresetItem.name,
        selectedPresetItem.width,
        selectedPresetItem.height,
        selectedPresetItem.length,
        selectedPresetItem.weight,
        selectedPresetItem.hazardous,
        quantity
    );

    // Find a container to add the item
    let itemPlaced = false;
    for (const container of containers) {
        if (container.canFitItem(newItem)) {
            container.addItem(newItem);
            itemPlaced = true;
            break;
        }
    }

    if (!itemPlaced) {
        // If no container can fit the item, create a new container
        createContainer();
        // Attempt to add the item to the newly created container
        for (const container of containers) {
            if (container.canFitItem(newItem)) {
                container.addItem(newItem);
                break;
            }
        }
    }

    // Display the updated containers
    displayContainers();

    // Clear the input fields
    document.getElementById("quantity").value = "";
}

// Function to place preset items into containers
function placePresetItems() {
    for (const presetItem of presetItems) {
        const selectedItem = presetItem.name;
        const quantity = parseInt(prompt(`Enter quantity for ${selectedItem}:`, "0"));

        if (!isNaN(quantity) && quantity > 0) {
            const selectedPresetItem = presetItems.find(item => item.name === selectedItem);

            if (selectedPresetItem) {
                // Create a new item object based on the selected preset item
                const newItem = new Item(
                    selectedPresetItem.name,
                    selectedPresetItem.width,
                    selectedPresetItem.height,
                    selectedPresetItem.length,
                    selectedPresetItem.weight,
                    selectedPresetItem.hazardous,
                    quantity
                );

                // Find a container to add the item
                let itemPlaced = false;
                for (const container of containers) {
                    if (container.canFitItem(newItem)) {
                        container.addItem(newItem);
                        itemPlaced = true;
                        break;
                    }
                }

                if (!itemPlaced) {
                    // If no container can fit the item, create a new container
                    createContainer();
                    // Attempt to add the item to the newly created container
                    for (const container of containers) {
                        if (container.canFitItem(newItem)) {
                            container.addItem(newItem);
                            break;
                        }
                    }
                }
            }
        }
    }

    // Function to add a preset container
    function addPresetContainer(presetContainer) {
        const container = new Container(
            presetContainer.width,
            presetContainer.height,
            presetContainer.length,
            presetContainer.maxWeight
        );

        // Check if there's enough space in the container
        if (!container.canFitItem(new Item("", presetContainer.width, presetContainer.height, presetContainer.length, presetContainer.maxWeight, false, 1))) {
            alert("Not enough space in the container for the initial item.");
            return;
        }

        containers.push(container);

        // Display the new container in the list
        displayContainers();
    }

    // Function to place preset containers
    function placePresetContainers() {
        for (const presetContainer of presetContainers) {
            addPresetContainer(presetContainer);
        }
    }






    }

// Function to display the list of containers
function displayContainers() {
    const containerList = document.getElementById("containerList");
    containerList.innerHTML = ""; // Clear the list

    containers.forEach((container, index) => {
        const containerItem = document.createElement("li");
        containerItem.textContent = `Container ${index + 1}: Remaining Space - Width: ${container.width} feet, Height: ${container.height} feet, Length: ${container.length} feet | Used Weight: ${container.currentWeight.toFixed(2)} / ${container.maxWeight} | Items:`;

        // Create a sub-list to display items and their quantities
        const itemSubList = document.createElement("ul");
        container.items.forEach((item) => {
            const itemListItem = document.createElement("li");
            itemListItem.textContent = `${item.name} (Quantity: ${item.quantity})`;
            itemSubList.appendChild(itemListItem);
        });

        containerItem.appendChild(itemSubList);
        containerList.appendChild(containerItem);
    });
}

// Preset items data
const presetItems = [
    {
        name: "Proformer Battery",
        width: 0.573,
        height: 0.625,
        length: 0.917,
        weight: 37.0,
        hazardous: true
    },
    {
        name: "Premium Brake Rotor",
        width: 1.083,
        height: 0.183,
        length: 1.083,
        weight: 26.4,
        hazardous: false
    },
    {
        name: "Proformer Air Filter",
        width: 0.773,
        height: 0.115,
        length: 1.042,
        weight: 2.0,
        hazardous: false
    }
    // Add more preset items as needed
];


// Containers array to store created containers
const containers = [];

// Initial display of containers
displayContainers();
